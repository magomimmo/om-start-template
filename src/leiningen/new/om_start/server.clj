;;; This namespace is used for development and testing purpose only.
(ns ring.server
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [compojure.route :refer  (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.adapter.jetty :as jetty]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [hickory.core :as hc]
            [hickory.render :as hr]
            [hickory.select :as hs]
            [hickory.zip :as hz]))

(defn repl-js-script []
  (-> (str "<script>" (browser-connected-repl-js) "</script>")
      hc/parse-fragment
      first
      hc/as-hickory))

(defn original-page []
  (-> "public/index.html"
      io/resource
      slurp
      hc/parse
      hc/as-hickory))

(defn page []
  (->> (original-page)
       hz/hickory-zip
       (hs/select-next-loc (hs/tag :body))
       (#(zip/append-child % (repl-js-script)))
       zip/root
       hr/hickory-to-html))

(defroutes site
  (resources "/")
  (GET "/*" req (page)))

(defn run
  "Run the ring server. It defines the server symbol with defonce."
  []
  (defonce server
    (jetty/run-jetty #'site {:port 3000 :join? false}))
  server)

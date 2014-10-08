(defproject {{raw-name}} "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.3.4"

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2342"]    
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]
                 [com.facebook/react "0.11.2"]]
  
  :plugins [[lein-cljsbuild "1.0.3"]]

  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:builds {:{{name}}
            {:source-paths ["src/cljs"]
             :compiler
             {:output-dir "dev-resources/public/js"
              :output-to "dev-resources/public/js/{{sanitized}}.js"
              :source-map "dev-resources/public/js/{{sanitized}}.js.map"
              :optimizations :advanced
              :pretty-print false}}}})

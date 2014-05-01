(defproject {{raw-name}} "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.3.4"

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.5.0"]
                 [com.facebook/react "0.9.0"]]
  
  :plugins [[lein-cljsbuild "1.0.2"]]

  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:builds {:{{name}}
            {:source-paths ["src/cljs"]
             :compiler
             {:output-to "dev-resources/public/js/{{sanitized}}.js"
              :optimizations :advanced
              :pretty-print false}}}})

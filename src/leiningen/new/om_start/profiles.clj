{:dev {:clean-targets ["out" :target-path]
       :resources-paths ["dev-resources"]
       :source-paths ["dev-resources/tools/http" "dev-resources/tools/repl"]
       :dependencies [[ring "1.2.1"]
                      [compojure "1.1.6"]
                      [enlive "1.1.4"]]
       :plugins [[com.cemerick/austin "0.1.3"]]
       :cljsbuild
       {:builds {:{{name}}
                 {:source-paths ["dev-resources/tools/repl"]
                  :compiler
                  {:optimizations :whitespace
                   :output-dir "dev-resources/public/js"
                   :source-map "dev-resources/public/js/{{sanitized}}.js.map"
                   :pretty-print true}}}}
        
       :injections [(require '[ring.server :as http :refer [run]]
                             'cemerick.austin.repls)
                    (defn browser-repl []
                      (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                               (cemerick.austin/repl-env))))]}}


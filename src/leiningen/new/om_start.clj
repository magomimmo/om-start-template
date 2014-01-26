(ns leiningen.new.om-start
  "Generate an OM project for nREPL compliant editors/IDEs"
  (:require [leiningen.new.templates :refer [renderer
                                             multi-segment
                                             sanitize-ns
                                             project-name
                                             name-to-path 
                                             year
                                             sanitize
                                             ->files]]
            [leiningen.core.main :as main]))

(defn om-start
  "A lein template for creating nREPL compliant OM project"
  [name]
  (let [render (renderer "om-start")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :sanitized (sanitize (project-name name))
              :year (year)}]
    (main/info "Generating a project called " name "based on the 'om-start' template")
    (main/info "To see other templates (app, lein plugin, etc), try `lein help new`.")
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["doc/intro.md" (render "intro.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["project.clj" (render "project.clj" data)]
             ["profiles.clj" (render "profiles.clj" data)]
             ["dev-resources/public/index.html" (render "index.html" data)]
             ["dev-resources/tools/http/ring/server.clj" (render "server.clj" data)]
             ["dev-resources/tools/repl/brepl/connect.cljs" (render "connect.cljs" data)]
             ["src/cljs/{{nested-dirs}}.cljs" (render "core.cljs" data)])))

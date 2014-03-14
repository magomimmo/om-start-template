# om-start

A Leiningen template for creating [OM][1] projects compatible with an
nREPL compliant editors/IDEs.

## Quick start

### Emacs/cider quick start

Start by creating a new OM project based on `om-start` lein-template.

```bash
lein new om-start om-tut
```

Then open the generated `core.cljs` file in Emacs from the
`src/cljs/om-tut` directory and run the `C-c M-j` shortcut (or `M-x
cider-jack-in`).

The command needs sometime to download dependencies and plugins, to
compile the ClojureScript code and to run the nREPL server and
client. So, be patient the very first time.

Once the nREPL is ready, evaluate the following Clojure forms:

```clj
(run) ; to run the included http server
```

and then

```clj
(browser-repl) ; to run the Browser Connected REPL
```

Finally, visit the `http://localhost:3000` URL to activate the Browser
Connected REPL.

You're now ready to follow the [David Nolen][2] [Tutorial on OM][3]
with the same kind of `live` experience he reached with
[Light Table][4].

Evaluate `core.cljs` file form by form starting from the namespace
declaration. To do that just position your cursor at the end of each
form and type `C-c C-e`.

### Eclipse/CCW  quick start

Start [CCW][5] by [Laurent Petit][6] and create a new `Clojure
Project` based on the `om-start` lein-template.

```bash
New > Clojure Project

Project Name: om-tut
Leiningen teamplate: om-start
```

From the contextual menu of the project select `Leiningen > Launch
Headless REPL for the Project`.

The command needs sometime to compile the ClojureScript code and to
run the nREPL server and client. So, be patient.

Once the nREPL is ready, evaluate the `(run)` form to start the
included http server.

Then start the Browser Connected REPL by evaluating the
`(browser-repl)` form.

When ready, visit the `http://localhost:3000` URL to activate the
ClojureScript REPL and you are ready to follow the [David Nolen][2]
[Tutorial on OM][3].

Open the `core.cljs` source code in the editor and evaluate it form by
form starting from the namespace declaration.

### Vim/fireplace quick start

Requires [vim-fireplace][8].

Start by creating a new OM project based on `om-start` lein-template and
launching the repl.

```bash
lein new om-start om-tut
cd om-tut
lein repl
```

`lein repl` will require some time to download dependencies and compile the
ClojureScript code.  Once the nREPL is ready, evaluate the following Clojure
forms:

```clj
(run) ; to run the included http server server.
```

Then open the generated `core.cljs` file in Vim from the
`src/cljs/om-tut` directory and enter the command

```vim
:Piggieback (browser-repl-env)
```
Finally, visit the `http://localhost:3000` URL to activate the Browser
Connected REPL.

You're now ready to follow the [David Nolen][2] [Tutorial on OM][3]
with the same kind of `live` experience he reached with
[Light Table][4].

Evaluate `core.cljs` file form by form starting from the namespace
declaration. To do that just position your cursor at the end of each
top-level form and type `cpp`.

> ATTENTION NOTE: `om-start` does not use `:none` optimization and
> this is because [austin][7] does not support it. 

## License

Copyright © 2014 Mimmo Cosenza (aka @magomimmo)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[1]: https://github.com/swannodette/om
[2]: https://github.com/swannodette
[3]: https://github.com/swannodette/om/wiki/Tutorial 
[4]: http://www.lighttable.com/
[5]: https://github.com/laurentpetit/ccw
[6]: https://github.com/laurentpetit
[7]: https://github.com/cemerick/austin
[8]: https://github.com/tpope/vim-fireplace


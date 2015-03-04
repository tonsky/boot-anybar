# boot-anybar

[Boot](https://github.com/boot-clj/boot) task that reports build status to [AnyBar](https://github.com/tonsky/AnyBar)

## Usage

Add `boot-anybar` to your `build.boot` dependencies and `require` the namespace:

```clj
(set-env! :dependencies '[
  [tonsky/boot-anybar "0.1.0" :scope "test"]
])

(require
  '[tonsky.boot-anybar :refer [anybar]])
```

Use `(anybar)` wherever you would use `(speak)` or `(notify)`.

To change AnyBar port, use `-p`:

```bash
boot anybar -p 1788 cljs
```

or in the `build.boot`:

```clj
(deftask build []
  (comp (anybar :port 1788)
        (cljs)))
```

## License

Copyright © 2015 Nikita Prokopov

Licensed under Eclipse Public License (see [LICENSE](LICENSE)).

(set-env!
  :source-paths #{"src"}
  :dependencies '[
    [org.clojure/clojure "1.6.0"      :scope "provided"]
    [boot/core           "2.0.0-rc11" :scope "provided"]
    [adzerk/bootlaces    "0.1.11"     :scope "test"]
  ])

(require
  '[adzerk.bootlaces :refer :all]
  '[boot.pod         :as pod]
  '[boot.util        :as util]
  '[boot.core        :as core])

(def +version+ "0.1.0")

(bootlaces! +version+)

(task-options!
 pom {:project 'tonsky/boot-anybar
      :version +version+
      :description "A boot task that reports build status to AnyBar (https://github.com/tonsky/AnyBar)"
      :url         "https://github.com/tonsky/boot-anybar"
      :scm         {:url "https://github.com/tonsky/boot-anybar"}
      :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

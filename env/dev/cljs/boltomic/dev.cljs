(ns ^:figwheel-no-load boltomic.dev
  (:require
    [boltomic.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)

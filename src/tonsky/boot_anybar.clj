(ns tonsky.boot-anybar
  {:boot/export-tasks true}
  (:require [clojure.java.io :as io]
            [clojure.java.shell :as sh]
            [boot.core :as core]
            [boot.util :as util]))

(defn- send-udp [s port]
  (with-open [socket (java.net.DatagramSocket.)]
    (let [group  (java.net.InetAddress/getByName "localhost")
          bytes  (.getBytes s)
          packet (java.net.DatagramPacket. bytes (count bytes) group port)]
      (.send socket packet)
      (.close socket))))
 
(core/deftask anybar
  "Reports build status to AnyBar"
  [p port VAL int "AnyBar port"]
  (let [port (or port 1738)]
    (fn [next-task]
      (fn [fileset]
        (try
          (send-udp "white" port)
          (util/with-let [_ (next-task fileset)]
            (if (zero? @core/*warnings*)
              (send-udp "black" port)
              (send-udp "orange" port)))
          (catch Throwable t
            (send-udp "red" port)
            (throw t)))))))

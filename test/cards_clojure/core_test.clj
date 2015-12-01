(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

(def hand-1 #{{:suit :clubs
                :rank 2}
               {:suit :clubs
                :rank 3}
               {:suit :clubs
                :rank :queen}
               {:suit :clubs
                :rank :king}
               })

(def hand-2 #{{:suit :diamonds
                :rank 2}
               {:suit :clubs
                :rank 3}
               {:suit :clubs
                :rank :queen}
               {:suit :clubs
                :rank :king}
                })

(deftest flush-test
  (testing "flush? returns true if the hand is a flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))

(def hand-3 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 2}
              })

(deftest four-of-a-kind-test
  (testing "four-of-a-kind? returns true if the hand is a four-of-a-kind"
    (is (= true (four-of-a-kind? hand-3)))
    (is (= false (four-of-a-kind? hand-2)))))

(def hand-4 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 3}
              })

(deftest three-of-a-kind-test
  (testing "three-of-a-kind? returns true if the hand is a three-of-a-kind"
    (is (= true (three-of-a-kind? hand-4)))
    (is (= false (three-of-a-kind? hand-2)))))

(def hand-5 #{{:suit :diamonds
               :rank 2}
              {:suit :diamonds
               :rank 3}
              {:suit :diamonds
               :rank 4}
              {:suit :diamonds
               :rank 5}
              })

(deftest straight-test                                      ;this test does not work for face cards....
  (testing "straight? returns true if the hand is a straight"
    (is (= true (straight? hand-5)))
    (is (= false (straight? hand-4)))))

(deftest straight-flush-test                                      ;this test does not work for face cards....
  (testing "straight-flush? returns true if the hand is a straight-flush"
    (is (= true (straight-flush? hand-5)))
    (is (= false (straight-flush? hand-4)))))

(deftest two-pair-test
  (testing "two-pair? returns true if the hand is a two-pair"
    (is (= true (two-pair? hand-3)))
    (is (= false (two-pair? hand-5)))))
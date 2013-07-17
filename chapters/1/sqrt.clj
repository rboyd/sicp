;;; 1.1.7 Example: Square Roots by Newton's Method
(defn good-enough?
  [guess x]
  (let [tolerance 0.001]
    (println guess)
    (< (Math/abs (- x (* guess guess))) tolerance)))

(defn average
  [x y]
  (/ (+ x y) 2))

(defn improve-guess
  [guess x]
  (double (average guess (/ x guess))))

(defn sqrt-iter
  [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve-guess guess x) x)))

(comment
  (def sqrt (partial sqrt-iter 1.0))
  (Math/abs -9)                         ;9
  (improve-guess 5 6)                   ;3.1
  (good-enough? 5.00001 25)             ;true
  (sqrt-iter 1 49)                      ;7.000000141269659
  )

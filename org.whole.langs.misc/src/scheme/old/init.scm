; eq? is defined as eqv?
(define eq? eqv?)

; not: boolean negation
(define (not x)
  (cond ((eqv? x #f) #t)
	(else #f)))

; equal?: structural equality
(define (equal? x y)
  (cond ((eqv? x y) #t)
	((and (pair? x) (pair? y))
	 (and (equal? (car x) (car y))
	      (equal? (cdr x) (cdr y))))
	((and (string? x) (string? y))
	 (string=? x y))
	(else #f)))

(define (exact? x)
  (cond ((integer? x) #t)
	(else #f)))

(define (inexact? x)
  (not (exact? x)))

(define (quotient x y) (/ x y))
(define (reminder x y) (- x (* (quotient x y) y)))

(define (zero? x) (= x 0))
(define (positive? x) (> x 0))
(define (negative? x) (< x 0))
(define (max x y)
  (cond ((>= x y) x)
	(else y)))
(define (min x y)
  (cond ((<= x y) x)
	(else y)))
(define (even? x) (= 0 (reminder x 2)))
(define (odd? x) (not (even? x)))

(define (abs x) 
  (cond ((< x 0) (- x))
	(else x)))

; functions on lists
(define (list? l)
  (cond ((null? l) #t)
	((pair? l) (list? (cdr l)))
	(else #f)))
(define (length l)
  (cond ((null? l) 0)
	(else (+ 1 (length (cdr l))))))
(define (append l m)
  (cond ((null? l) m)
	(else (cons (car l) (append (cdr l) m)))))
(define (reverse l)
  (local ((define (aux l1 l2)
	    (cond ((null? l2) l1)
		  (else (aux (cons (car l2) l1) (cdr l2))))))
	 (aux (list) l)))

; misc recursive functions
(define (fibo x)
  (cond ((<= x 1) 1)
	(else (+ (fibo (- x 1)) (fibo (- x 2))))))

(define (map f l)
  (cond ((null? l) (list))
	(else (cons (f (car l)) (map f (cdr l))))))

(define (filter f l)
  (cond ((null? l) (list))
	((f (car l)) (cons (car l) (filter f (cdr l))))
	(else (filter f (cdr l)))))

; main program
(define (main args)
  (reverse (list 1 2 3 4 5 6 7 8 9 10)))


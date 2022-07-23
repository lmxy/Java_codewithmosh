# Learning Java with English tutorial
- 2022, July 23 ~~ Day 53
---

## Java syntax

1. Peeking element
2. reducers
> - count()
> - anyMatch(predicate) 
> - allMatch(predicate)
> - noneMatch(predicate)
> - findFirst()
> - findAny()
> - mac(comparator)
> - min(comparator)
3. Optional
```java
var result = movies.stream()
                   .min(Comparator.comparing(Movie::getLikes)) // Optional
                   .get(); 
```
## Unfamiliar terms and words
1. distinct `adj` recognizably different in nature from something else or a similar type.; clearly different of of a different kind;
2. accumulate `v.` gather together or acquire an increasing number or quantity of.
3. delimiter `n.` a blank space, comma, or other character or symbol that indicated the beginning or end of a character string, word, or data item.
4. thriller `n.` a book, play or film/movie with an exciting story, expecially one about crime or spying
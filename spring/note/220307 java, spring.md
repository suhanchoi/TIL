# 220307



## Spring , Java 복습

 


``` java
// Controller

@RequestParam(defaultValue = "10") int size
    
return ResponseEntity(SUCCESS, status = HttpStatus.OK);

Map<String, Object> result = new HashMap<>;
result.put("result", SUCCESS);

@GetMapping("/{postId}/comment")
public List<CommentDto> fetchComments(@PathVariable Long postId) {
    List<Comment> comments = commentService.fetchComments(postId);
    return comments.stream().map(CommentDto::new).collect(Collectors.toList());// dto 변환
```



```java
// Domain

// Member
@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberFondAromaHashTag> memberFondAromaHashTags = new ArrayList<>();
```



```java
// DTO

// BeerDTO
aromaHashTags = beer.getBeerHasAromaHashTags()
                .stream()
                .map(beerHasAromaHashTag ->
                        beerHasAromaHashTag.getAromaHashTag().getAroma()
                ).collect(Collectors.toList());

OptionalDouble average = beer.getMemberRateBeers().stream().mapToInt(MemberRateBeer::getRate).average();


// PostDTO
for (UserHashTag userHashTag :
                userHashTags) {
            if (!userHashTag.is_deleted()) {
                this.userHashTags.add(new UserHashTagDto(userHashTag.getUserHashTagId(), userHashTag.getContent()));
            }
        }

this.likes = post.getMemberLikePosts().stream().count();
```



```java
// Repository

// BeerRepository
@Query("select beer from Beer beer join fetch beer.beerType order by beer.beerId")
    List<Beer> findAllWithBeerType(Pageable pageable);
```



```java
// scheduler

// clearance 오전 7시 마다 배치 프로그램, http 쿼리 요청
@Scheduled(cron = "0 0 7 * * *", zone = "Asia/Seoul")
    public void deleteESUserHashTag() {
        String json = "{\"query\":{\"match\":{\"is_deleted\":true}}}";
        String url = "http://i6c107.p.ssafy.io:9201/userhashtag/_delete_by_query";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        restTemplateBuilder.build().postForLocation(url, request);
    }
```



```java
// Service

@RequiredArgsConstructor

    private final BeerRepository beerRepository;

    public Optional<Beer> fetchBeer(Long beerId) {
        return beerRepository.findById(beerId);
    }

@Transactional

        List<RateHasFlavorHashTag> flavorHashTags =
                flavorHashTagRepository.findAllById(flavorHashTagIds)
                        .stream()
                        .map(flavorHashTag -> RateHasFlavorHashTag.createRateHasFlavorHashTag(flavorHashTag, memberRateBeer))
                        .collect(Collectors.toList());
```


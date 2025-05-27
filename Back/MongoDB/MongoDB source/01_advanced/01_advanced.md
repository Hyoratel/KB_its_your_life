# MongoDB(심화)

## 1.자바스크립트 셸을 통한 MongoDB(심화1)

### 1. users 컬렉션에 {username: "smith"} 문서를 추가하세요.
```js
// MongoDB shell에서 실행
use users
db.users.insertOne(
  {username:"smith"})
```

### 1-1. 위의 문서를 다음과 같이 되도록 수정하세요.
```js
db.users.update({username:"smith"},
    {$set:{
        favorites:{cities:["Chicago","Cheyenne"],
        movies:["Casablanca", "For a Few Dollars More", "The String"]}
        }})
```

### 2. users 컬렉션에 {username: “jones"} 문서를 추가하세요.
```js
db.users.insert({username:"jones"})
```

### 2-1. 위의 문서를 다음과 같이 되도록 수정하세요.
```js
db.users.update({username:"jones"},
    {$set:{
        favorites:{
            movies:["Casablanca","Rocky"]
        }
        }})
```

### 3. users 컬렉션의 "Casablanca" 영화를 좋아하는 사용자들을 출력하세요.
```js
db.users.find({"favorites.movies": "Casablanca"})
// .pretty() : 들여쓰기
```

### 4. users 컬렉션의 "Casablanca" 영화를 좋아하는 사용자들에 대해서 좋아하는 영화 목록에 "The Maltese Falcon"을 중복 없이 추가하세요.
- 단, 해당 항목이 없는 경우는 무시하고, 여러 사람이 일치한다면 모두 업데이트 하세요.
```js
db.users.updateMany(
    {"favorites.movies":"Casablanca"},
    {$addToSet:{
        "favorites.movies":"The Maltese Falcon"
        }},
    {upsert:false}
)
/** $addToSet : 이미 값이 있을 경우 중복 추가하지 않음.
 * upsert : 조건에 맞는 문서가 없을 경우 새 문서를 생성하지 않음
 */
```
## 2.자바스크립트 셸을 통한 MongoDB (심화2)
### 1. numbers 컬렉션에 20,000개의 문서를 생성하세요.
- 문서의 형태: {num:i}
```js
for(let i = 0; i<20000; i++){
    db.numbers.insert({num:i})
}
```

### 2.numbers 컬렉션의 문서 개수를 출력하세요.
```js
db.numbers.count()
```

### 3. numbers 컬렉션에서 num의 값이 20이상 25이하인 문서를 출력하세요.
```js
db.numbers.find({num:{"$gte":20,"$lte":25}})
//$gte : getter than or equal
```

### 4. 위 쿼리의 실행 통계를 출력하세요.
```js
db.numbers.find({num:{"$gte":20,"$lte":25}}).explain("executionStats")
//explain("executionStats") : 쿼리 실행 시 실제로 몇 건을 읽고, 필터링했는지 등의 상세 실행 통계
```

### 5. numbers 컬렉션의 num 키에 대해서 인덱스를 생성하세요.
```js
db.numbers.ensureIndex({num:1}) // 구버전
db.numbers.createIndex({ num: 1 }) //신버전
```

### 6. 위에서 생성한 인덱스 정보를 출력하세요.
```js
db.numbers.getIndexes()
```

### 7. 앞에서 작성한 범위 연산 쿼리의 실행 통계를 출력하고, 인덱스가 없을 때와 비교해보세요.
```js
db.numbers.find({num:{"$gte":20,"$lte":25}}).explain("executionStats")
// 인덱스 설정 시 인덱스 설정값들만 분석하기 때문에 성능적으로 우수하다.
```

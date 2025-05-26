# MongoDB(기본)

## 1.자바스크립트 셸을 통한 MongoDB(기본)

### 1. 데이터베이스를 tutorial로 선정하세요.

```js
use tutorial
```

### 2. users 컬렉션에 username이 smith인 문서를 저장하세요.

```js
db.users.insertOne({ username: 'smith' });
```

### 3. users 컬렉션에 username이 jones인 문서를 저장하세요.

```js
db.users.insertOne({ username: 'jones' });
```

### 4. 앞에서 저장한 모든 문서를 출력하세요.

```js
db.users.find();

//_id 제거시
dn.users.find({}, { _id: 0 });
```

### 5. 앞에서 저장한 문서 중 하나 만 출력하세요.

```js
db.users.findOne();
```

### 6. users 컬렉션에서 username이 "jones"인 문서를 찾아서 출력하세요.

```js
db.users.findOne({ username: 'jones' });
```

### 7. users 컬렉션에서 username이 "jones" 또는 "smith"인 문서를 찾아서 출력하세요.

```js
db.users.find({ $or: [{ username: 'smith' }, { username: 'jones' }] });
```

### 8. users 컬렉션에서 username이 smith인 문서에 country 키가 Canada 가 되도록 수정하세요.

```js
db.users.update({ username: 'smith' }, { $set: { country: 'Canada' } });
```

### 9. 앞의 문서가 올바르게 수정되었는지 확인하세요.

```js
db.users.find({username:"smith"})

{
  _id: ObjectId('6833f920390d5dd0dd5cf815'),
  username: 'smith',
  country: 'Canada'
}
```

### 10. users 컬렉션에서 username이 smith인 문서를 {country: "Canada"}로 대체하고 확인하세요.

```js
db.users.updateOne(
    {username:"smith"},
    {$set:{country:"Canada"}}
)

db.users.find(
    {country: "Canada"}


{
  _id: ObjectId('6833f920390d5dd0dd5cf815'),
  username: 'smith',
  country: 'Canada'
})
```

### 11. users 컬렉션에서 country가 Canada인 문서를 {username: "Smith", country: "Canada"}로 대체하고 확인하세요.

```js
db.users.update(
    {country:"Canada"},
    {$set: {username:"Smith", country:"Canada"}}
)

db.users.find({username:"Smith"})

{
  _id: ObjectId('6833f920390d5dd0dd5cf815'),
  username: 'Smith',
  country: 'Canada'
}
```

### 12.users 컬렉션에서 username이 smith인 문서에서 country 키를 삭제하고, 삭제 여부를 확인하세요.

```js
db.users.update(
    {username:"Smith"},
    {$unset:{country:1}} //country 제거하겠단 뜻
)
db.users.find({username:"Smith"})

{
  _id: ObjectId('6833f920390d5dd0dd5cf815'),
  username: 'Smith'
}
```

### 13. 데이터베이스 전체 목록을 출력하세요.

```js
show dbs

admin      40.00 KiB
config    108.00 KiB
local      40.00 KiB
tutorial   72.00 KiB
```

### 14. 현재 사용 중인 데이터베이스의 컬렉션 목록을 출력하세요.

```js
show collections

users
```

### 15. 현재 사용 중인 데이터베이스와 users 컬렉션의 상태를 출력하세요.

```js
db.stats();

db.users.stats();
```

### 16. users 컬렉션에서 username이 smith인 문서를 삭제하고, 삭제여부를 확인하세요.

```js
db.users.remove(
    {username:"Smith"}
)
db.users.find()

{
  _id: ObjectId('6833f948390d5dd0dd5cf816'),
  username: 'jones'
}
```

### 17. users 컬렉션의 모든 문서를 삭제하고, 삭제 여부를 확인하세요.

```js
db.users.remove({});

db.users.find();
```

### 18. users 컬렉션을 삭제하세요.

```js
db.users.drop()
show dbs

admin    40.00 KiB
config  108.00 KiB
local    40.00 KiB
```

## 2. 쿼리작성하기(기본)

### 1.다음 형태의 문서 20,000건을 추가하세요.

```js
use test

for(let i =0; i<20000; i++){
db.product.insert({
num:i,name:'스마트폰 '+i});
}

```

### 2. product 컬렉션의 전체 문서수를 출력하세요.

```js
db.product.count();
```

### 3. product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 출력하세요.

```js
db.product.find().sort({ num: -1 });
```

### 4. product 컬렉션의 문서를 num의 내림 차순으로 정렬하여 상위 10건을 출력하세요.

```js
db.product.find().sort({ num: -1 }).limit(10);
```

### 5. product 컬렉션의 문서를 num의 내림 차순으로 정렬한 상태에서 다음을 처리하세요.

- 한 페이지당 10건씩 출력
- 6페이지에 해당하는 문서를 출력

```js
db.product
  .find()
  .sort({ num: -1 })
  .skip(10 * (6 - 1))
  .limit(10);
```

### 6. product 컬렉션에서 num이 15미만 이거나 19995 초과인 것을 출력하세요.

```js
db.product.find({ $or: [{ num: { $lt: 15 } }, { num: { $gt: 19995 } }] });
```

### 7. product 컬렉션에서 name이 '스마트폰 10', '스마트폰 100', '스마트폰 1000' 중에 하나이면 출력하세요.

```js
db.product.find({
  name: { $in: ['스마트폰 10', '스마트폰 100', '스마트폰 1000'] },
});
```

### 8. product 컬렉션에서 num이 5보다 작은 문서를 출력하는데, name만 출력하세요.(\_id 출력하면 안됨)

```js
db.product.find({ num: { $lt: 5 } }, { _id: 0, name: 1 });
```

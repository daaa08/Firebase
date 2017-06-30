## Firebase

- 실시간으로 단말기와 서버간의 통신이 가능
- Nosql(JSON형식)

> to Use (2017.6.30일자 기준)

1. tools > Firebase
2. 실시간 서버 통신 Realtime Database 선택하여 Firebase 홈페이지에 로그인 후 프로젝트 생성

![스크린샷 2017-06-30 오후 9.11.39](http://i.imgur.com/9lbPU6r.png)

3. Connection your app to Firebase와 Add the RealTime Database to your app 연결 - 자동으로 Gradle에 추가 됨
4. 코드에 추가 _ 자동으로 루트가 생성 됨(트리구조)
```java
// 파이어베이스의 데이터베이스에 연결
FirebaseDatabase database = FirebaseDatabase.getInstance();
// 래퍼런스를 가져옴
DatabaseReference myRef = database.getReference("message");

myRef.setValue("Hello, World!");
```
> 데이터 입력시

![스크린샷 2017-07-01 오전 12.06.46](http://i.imgur.com/Fx1ybKo.png)

5. 코드에 추가
```java
myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      // 데이터 변경사항이 생기면 담아줌
        String value = dataSnapshot.getValue(String.class);
        Log.d(TAG, "Value is: " + value);
    }

    @Override
    public void onCancelled(DatabaseError error) {
        Log.w(TAG, "Failed to read value.", error.toException());
    }
});
```

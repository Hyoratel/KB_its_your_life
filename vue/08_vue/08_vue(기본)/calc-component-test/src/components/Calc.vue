<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>
<script>
// ref : 기본타입의 값을 반응형으로 만들때 사용하는 함수
import { ref } from 'vue';
export default {
  name: 'Calc',
  setup() {
    const x = ref(10); // 10으로 초기화
    const y = ref(20); // 20으로 초기화
    return { x, y };
  },
};
</script>

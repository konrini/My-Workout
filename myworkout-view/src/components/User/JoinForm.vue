<template>
  <div>
      <h3>
        Join
      </h3>

  <div class="container">
		<form @submit.prevent="submitForm">
			<div>
				<label for="name">Name</label>
				<input type="text" id="name" v-model="name" />
			</div>
			<div>
				<label for="nickname">Nickname</label>
				<input type="text" id="nickname" v-model="nickname" />
			</div>
      <div>
				<label for="id">ID</label>
				<input type="text" id="id" v-model="id" />
			</div>
			<div>
				<label for="password">비밀번호</label>
				<input type="password" id="password" v-model="password" />
			</div>
			<div>
				<label for="passwordConfirm">비밀번호 확인</label>
				<input type="password" id="passwordConfirm" v-model="passwordConfirm" />
			</div>
      <div>
				<label for="height">height</label>
				<input type="number" id="height" v-model="height" />
			</div>
      <div>
				<label for="weight">Weight</label>
				<input type="number" id="weight" v-model="weight" />
			</div><br>
      <div id="select-gender">
        Gender: {{ selectedGender }} <br>
        <input type="radio" name="gender" id="male" value="Male" v-model="selectedGender" />
				<label for="male">Male</label>
				<input type="radio" name="gender" id="female" value="Female" v-model="selectedGender" />
				<label for="female">Female</label><br>
			</div><br>
      <div id="selected-photo">
        Selected photo: {{ selectedPhoto }}<br>
				<input type="radio" name="photo" id="1" value="1" v-model="selectedPhoto"/>
        <label for="photo1">
          <img src="@/assets/photo/1.png" alt="Cat">
        </label>
        <input type="radio" name="photo" id="2" value="2" v-model="selectedPhoto"/>
        <label for="photo2">
          <img src="@/assets/photo/2.png" alt="Dog">
        </label>
        <input type="radio" name="photo" id="3" value="3" v-model="selectedPhoto"/>
        <label for="photo3">
          <img src="@/assets/photo/3.png" alt="Hippo">
        </label>
        <input type="radio" name="photo" id="4" value="4" v-model="selectedPhoto"/>
        <label for="photo4">
          <img src="@/assets/photo/4.png" alt="Giraffe">
        </label>
        <input type="radio" name="photo" id="5" value="5" v-model="selectedPhoto"/>
        <label for="photo5">
          <img src="@/assets/photo/5.png" alt="Tiger">
        </label>
        <input type="radio" name="photo" id="6" value="6" v-model="selectedPhoto"/>
        <label for="photo6">
          <img src="@/assets/photo/6.png" alt="Pig">
        </label>
			</div>
      <div>
				<label for="treasure">Treasure</label>
				<input type="text" id="treasure" v-model="treasure" placeholder="비밀번호 분실 시 힌트" />
			</div>
			<button type="submit">회원가입</button>
		</form>
	</div>


  </div>
</template>

<script>
export default {
  name: 'JoinForm',
  data(){
    return{
      name: '',
      nickname: '',
      id:'',
      password: '',
      passwordConfirm: '',
      height:0,
      weight:0,
      selectedGender: [],
      selectedPhoto: [],
      photo: 0,
      treasure: '',
    };
  },
  methods:{
    submitForm(){
      console.log('submitted!');
    },
  }
}
</script>

<style>
img{
  width: 50px;
  height: 50px;
}
</style>
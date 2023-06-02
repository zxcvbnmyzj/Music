<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="150px" class="login-box">
      <h3 class="login-title">Register</h3>
      <el-form-item label="Name:" prop="name">
        <el-input type="text" placeholder="Name" v-model="form.name"/>
      </el-form-item>
      <el-form-item label="Password:" prop="password">
        <el-input type="password" placeholder="Password" v-model="form.password"/>
      </el-form-item>
      <el-form-item label="Confirm Password:" prop="conPassword">
        <el-input type="password" placeholder="Confirm Password" v-model="form.conPassword"/>
      </el-form-item>
      <el-form-item label="sex:" prop="sex">
        <el-radio v-model="form.radio" label="1">man</el-radio>
        <el-radio v-model="form.radio" label="2">girl</el-radio>
      </el-form-item>
      <el-form-item label="Phone Number:" prop="phoneNumber">
        <el-input type="text" placeholder="phone number" v-model="form.phoneNumber"/>
      </el-form-item>
      <el-form-item>
        <el-button v-on:click="register">Register</el-button>
        <el-button v-on:click="close">Close</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      form: {
        name: '',
        password: '',
        conPassword: '',
        radio: '1',
        phoneNumber: ''
      },
      rules: {
        name: [{required: true, message: 'Account cannot be empty', trigger: 'blur'}],
        password: [{required: true, message: 'Password cannot be empty', trigger: 'blur'}],
        conPassword: [{required: true, message: 'Confirm Password cannot be empty', trigger: 'blur'}],
        phoneNumber: [
          {
            required: true,
            message: 'Please enter the correct phone number',
            trigger: 'blur'
          }
        ]
      },
      responseResult: [],
      dialogVisible: false
    }
  },
  methods: {
    close () {
      this.$message.info('Returned')
      this.$router.push('/')
    },
    register () {
      this.checkPassword()
      this.checkPhoneNumber(this.form.phoneNumber)
    },
    checkPassword () {
      if (this.form.password !== this.form.conPassword) {
        this.$message.error('Password inconsistency')
      }
    },
    checkPhoneNumber (phone) {
      if (!/^1[3-9]\d{9}$/.test(phone)) {
        this.$message.error('Please enter a valid phone number')
      }
    }
  }
}
</script>

<style scoped>
.login-box {
  border: 1px solid #DCDFE6;
  width: 500px;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #909399;
}

.login-title {
  text-align: center;
  margin: 0 auto 40px auto;
  color: #303133;
}
</style>

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
        <el-input type="text" placeholder="phone number" v-model="form.phone"/>
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
    var checkPhone = (rule, value, callback) => {
      let regPhone = null
      let mobile = /^((13|14|15|17|18)[0-9]{1}\d{8})$/
      let tel = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/
      if (value !== null && value.charAt(0) === '0') {
        regPhone = tel
      } else if (value !== null && value.charAt(0) === '0') {
        regPhone = mobile
      }
      if (regPhone === null) {
        return callback(
          new Error('Please enter a phone number')
        )
      } else if (!regPhone.test(value)) {
        return callback(
          new Error('Please enter the correct phone format, where landline format is Area code landline number ')
        )
      } else {
        callback()
      }
    }
    return {
      form: {
        name: '',
        password: '',
        conPassword: '',
        radio: '',
        phone: ''
      },
      rules: {
        name: [{required: true, message: 'Account cannot be empty', trigger: 'blur'}],
        password: [{required: true, message: 'Password cannot be empty', trigger: 'blur'}],
        conPassword: [{required: true, message: 'Confirm Password cannot be empty', trigger: 'blur'}],
        phoneNumber: [ {
          required: true,
          validator: checkPhone,
          trigger: 'blur'
        }]
      },
      responseResult: [],
      dialogVisible: false
    }
  },
  methods: {
    close () {
      this.$router.push('/')
    },
    register () {
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

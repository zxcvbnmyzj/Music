<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="74px" class="login-box">
      <h3 class="login-title">Login</h3>
      <el-form-item label="Name:" prop="name">
        <el-input type="text" placeholder="Name" v-model="form.name"/>
      </el-form-item>
      <el-form-item label="Password:" prop="password">
        <el-input type="password" placeholder="Password" v-model="form.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onLogin">Login</el-button>
        <el-button v-on:click="outLogin('loginForm')">Close</el-button>
        <el-button v-on:click="register">Register</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      form: {
        name: '',
        password: ''
      },
      rules: {
        name: [{required: true, message: 'Account cannot be empty', trigger: 'blur'}],
        password: [{required: true, message: 'Password cannot be empty', trigger: 'blur'}]
      },
      responseResult: [],
      dialogVisible: false
    }
  },
  methods: {
    onLogin () {
    },
    outLogin (forName) {
      this.$refs[forName].resetFields()
    },
    register () {
      this.$router.push('/register')
    }
  }
}
</script>

<style scoped>
.login-box {
  border: 1px solid #DCDFE6;
  width: 350px;
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

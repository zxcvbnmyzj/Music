<template>
    <div>
        <img src="../assets/yohaneIcon.jpg"/>
        <h1>Login</h1>
        <ul>
            <li>
                <div class="inputBox">
                    <input type="text" v-model="loginForm.loginName" placeholder="请输入用户名">
                </div>
            </li>
            <li class="inputBox">
                <div>
                    <input type="text" v-model="loginForm.password" placeholder="请输入密码">
                </div>
            </li>
        </ul>
        <button type="primary" @click="login">Login</button>
    </div>
</template>

<script>
    import { userLogin } from '@/api/user';
    export default {
        name:"Login",
        data(){
            return{
                loginForm:{
                    loginName:"",
                    password:""
                },
                responseResult:[],
            };
        },
        methods:{   
            login(){
                var _this = this;
                userLogin({
                    loginName: this.loginForm.loginName,
                    password: this.loginForm.password,
                }).then((resp) => {
                    let code = resp.data.code;
                    if(code === 200){
                        let data = resp.data.data;
                        let token = data;
                        let user = data.user;
                        _this.$store.commit('SET_TOKENN',token);
                        _this.$store.commit('SET_USER',user);
                        console.log(_this.$store.state.token);
                        var path = this.$route.query.redirect
                        this.$router.replace({path: path === '/' || path === undefined ? '/' : path})
                    }else{
                        console.log(err);
                        this.$message.error("用户名或者密码错误");
                    }
                })
                .catch((err)=>{
                    console.log(err);
                    this.$message.error("连接服务器失败");
                });
            }
        },
    };
</script>

<style>
img{
    width: 15%;
    height: 15%;
}
input{
    outline: none;
    border: none;
    font-size: 20px;
    width: 100%;
}
ul{
    padding: 0;
    width: 100%;
    text-align: center;
    margin: 0 auto;
}
ul li{
    list-style-type: none;
}
.inputBox{
    width: 300px;
    margin: 3vw auto;
    padding: 5px 20px;
    border: 10px solid #AEAEAE;
    border-radius: 25px;
}
button{
    width: 150px;
    padding: 20px 30px;
    border: none;
    background-color: #000;
    border-radius: 30px;
    color: #fff;
    font-size: 20px;
    text-align: center;
}
</style>
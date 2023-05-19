<template>
    <el-container class="home-contatiner">
        <!-- top -->
        <el-header style="margin-right: 15px; width: 100%;">
            <img class="nav-logo" src="../../assets/yohaneIcon.jpg">
            <!-- <span class="nav-logo">😀</span> -->
            <span class="head-title">YoHaNe Home</span>
            <el-input class="searchInput"
                placeholder="搜索音乐"
                v-model="input"
                clearable/>
            <el-avatar icon="el-icon-user-solid"
            style="color: #222; float: right; padding: 20px;">
                {{ this.$store.state.user.name }}
            </el-avatar>
        </el-header>
        <!-- main -->
        <el-container>
            <!-- left-nav -->
            <el-aside width="13%">
                <el-menu
                    :default-active="$route.path"
                    router
                    text-color="black"
                    active-text-color="red">
                    <el-menu-item
                        v-for="(item,i) in navList"
                        :key="i"
                        :index="item.name">
                        <i :class="item.icon"/>
                        {{ item.title }}
                    </el-menu-item>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Home",
        data(){
            return{
                navList:[
                    {name:"/index",title:"首页",icon:"el-icon-s-home"},
                    {name:"/singer",title:"歌手",icon:"el-icon-s-custom"},
                    {name:"/sheet",title:"自建歌单",icon:"el-icon-folder-opened"},
                    {name:"/user",title:"用户管理",icon:"el-icon-user-solid"},  
                ],
                input:''
            };
        },
    };
</script>


<style>
.searchInput{
    max-width: 40%;
    position: absolute;
    left: 30%;
}
.nav-logo{
    width: 3%;
    height: 6%;
    position: absolute;
    left: 5%;
}
.head-title{
    position: absolute;
    font-size: 20px;
    font-weight: bold;
    left: 15%;
}
</style>
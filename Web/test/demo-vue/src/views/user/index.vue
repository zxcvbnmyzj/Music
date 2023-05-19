<template>
    <div class="user-Manger">
        <div class="userManger">
            <div class="user-head">
                <el-input
                class="searchUser"
                placeholder="请输入内容"
                v-model="queryInfo.keyword"
                clearable
                @clear="getUserList"
                >
                <el-button
                    slot="append"
                    icon="el-icon-search"
                    @click="getUserList"/>
                </el-input>
                <el-button class="user-adduser-bt" @click="addDialogVisible = true">添加用户</el-button>
                <el-button class="user-batchDelete-bt" @click="batchDeleteUser">批量删除</el-button>
            </div>
        
            <el-table
            :data="userList"
            @selection-change="handleSelectionChange"
            border
            stripe>
                <el-table-column type="selection" width="50"/>
                <el-table-column prop="id" label="序号"/>
                <el-table-column prop="name" label="用户名"/>
                <el-table-column prop="password" label="密码"/>
                <el-table-column prop="sex" label="性别"/>
                <el-table-column prop="email" label="邮箱"/>
                <el-table-column prop="state" label="状态"/>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                            type="primary"
                            size="mini"
                            icon="el-icon-edit"
                            @click="showEditDialog(scope.row)"/>
                        <el-button
                            type="danger"
                            size="mini"
                            icon="el-icon-delete"
                            @click="removeUserById(scope.row.id)"/>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <!-- 分页 -->
        <el-pagination
                class="pagination"
                background
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="queryInfo.pageNo"
                :page-sizes="[1,2,5,10]"
                :page-size="queryInfo.pageSize"
                layout="total,sizes,prev,pager,next,jumper"
                :total="total">
        </el-pagination>
        <!-- 添加用户 -->
        <el-dialog
            class="userDialog"
            title="添加用户"
            :visible.sync="addDialogVisible"
            @close="addDialogClosed">
            <el-form
                :model="userForm"
                label-width="70px">
                <el-form-item prop="userName" label="用户名">
                    <el-input v-model="userForm.name"></el-input>
                </el-form-item>
                <el-form-item prop="password" label="密码">
                    <el-input v-model="userForm.password"></el-input>
                </el-form-item>
                <el-form-item prop="sex" label="性别">
                    <el-input v-model="userForm.sex"></el-input>
                </el-form-item>
                <el-form-item prop="email" label="邮箱">
                    <el-input v-model="userForm.email"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取消</el-button>
                <el-button type="primary" @click="addUser">确定</el-button>
            </span>
        </el-dialog>
        <!-- 修改用户 -->
        <el-dialog class="edit-dialog" title="修改用户" :visible.sync="editDialogVisible">
            <el-form :model="editForm" label-width="70px">
                <el-form-item label="ID" prop="id">
                    <el-input v-model="editForm.id" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="用户名" prop="name">
                    <el-input v-model="editForm.name"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="editForm.password" ></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                    <el-input v-model="editForm.sex" ></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="editForm.email" ></el-input>
                </el-form-item>
                <el-form-item label="状态" prop="state">
                    <el-input v-model="editForm.state" ></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editDialogVisible = false">取消</el-button>
                <el-button type="primary" @click="editUser">确定</el-button>
            </span>
        </el-dialog>
    </div>
    
    
</template>


<script>
import {userList} from "@/api/user";
import {userAdd} from "@/api/user";
import {userUpdate} from "@/api/user";
import {userDelete} from "@/api/user";
import {userBatchDelete} from "@/api/user";

export default {
    name: "User",
    data(){
        return {
            userList:[],
            total:0,//用户总数
            queryInfo:{
                keyword:"",//查询参数
                pageNo:1,//页码
                pageSize:5,//每页条数
            },
            addDialogVisible:false,
            userForm:{
                id:"",
                name:"",
                password:"",
                sex:"",
                email:"",
                state:""
            },
            editDialogVisible:false,
            editForm:{
                id:"",
                name:"",
                password:"",
                sex:"",
                email:"",
                state:"",
            },
            multipleSelection:[],
            ids:[]
        }

    },
    created(){
        this.getUserList()
    },
    methods:{
        handleSizeChange(newSize){
            this.queryInfo.pageSize = newSize;
            console.log(this.queryInfo.pageSize)
            this.getUserList();
        },
        handleCurrentChange(newPage){
            this.queryInfo.pageNo = newPage;
            console.log(this.queryInfo.pageNo)
            this.getUserList();
        },
        handleSelectionChange(val){
            this.multipleSelection = val;
            this.multipleSelection.forEach((item)=>{
                this.ids.push(item.id);
                console.log(this.ids);
            });
        },
        getUserList(){
            userList(this.queryInfo)
            .then((res)=>{
                if(res.data.code === 200){
                    this.userList = res.data.data.records;
                    console.log(res.data.data.records);
                    this.total = res.data.data.total;
                }else{
                    this.$message.error(res.data.message);
                }
            })
            .catch((err)=>{
                console.log(err);
            });
        },
        addUser(){
            userAdd(this.userForm).then((res)=>{
                if(res.data.code === 200){
                    this.addDialogVisible = false;
                    this.getUserList();
                    this.$message({
                        message:"添加用户成功",
                        type:"success",
                    });
                }else{
                    this.$message.error("添加失败");
                }
            })
            .catch((err)=>{
                this.$message.error("添加用户异常,请稍后重试");
                console.log(err);
            });
        },
        addDialogClosed(){//监听 添加用户对话框的关闭事件
            //表单内容重置为空
            this.$refs.addFormRef.resetFields();
        },
        showEditDialog(userinfo){
            this.editDialogVisible = true;
            console.log(userinfo);
            this.editForm = userinfo;
        },
        editUser(){
            userUpdate(this.editForm).then((res)=>{
                if(res.data.code === 200){
                    this.editDialogVisible = false;
                    this.getUserList();
                    this.$message({
                        message:"修改用户成功",
                        type:"success"
                    });
                }else{
                    this.$message.error("修改失败");
                }
            })
            .catch((err)=>{
                this.$message.error("修改异常,请稍后再试");
                console.log(err);
            })
        },
        async removeUserById(id){
            const confirmResult = await this.$confirm("此操作将永久删除该用户,是否继续?","提示",{
                confirmButtonText:"确定",
                cancelButtonText:"取消",
                type:"warning"
            }).catch((err)=>err);
            if(confirmResult == "confirm"){
                userDelete(id).then((res)=>{
                    if(res.data.code === 200){
                        this.getUserList();
                        this.$message({
                            message:"删除用户成功",
                            type:"success",
                        })
                    }else{
                        this.$message.error("删除用户失败");
                    }
                }).catch((err)=>{
                    this.$message.error("删除用户异常,请稍后再试");
                    console.log(err);
                })
            }
        },
        async batchDeleteUser(){
            const confirmResult = await this.$confirm("此操作将永久删除用户,是否继续?","提示",{
                confirmButtonText:"确定",
                cancelButtonText:"取消",
                type:"warning"
            }).catch((err)=>err);
            if(confirmResult == "confirm"){
                userBatchDelete(this.ids).then((res)=>{
                    if(res.data.code === 200){
                        this.$message({
                            message:"批量删除用户成功",
                            type:"success"
                        });
                        this.getUserList();
                    }else{
                        this.$message.error("批量删除用户失败");
                    }
                }).catch((err)=>{
                    this.$message.error("批量删除用户异常,请稍后再试");
                    console.log(err);
                });
            }
        }
    },
    
}

</script>

<style>
.pagination{
    width: 100%;
}
.user-head{
    text-align: left;
}
.searchUser{
    margin: 0 10px 20px 0;
    width: 70%;
}
.user-Manger{
    width: 100%;
}
.userDialog{
    width: 100%;
}
.edit-dialog{
    width: 100%;
}
.user-adduser-bt:hover{
    background: blue;
    color: #fff;
}
.user-batchDelete-bt:hover{
    background: red;
    color: #fff;
}
</style>
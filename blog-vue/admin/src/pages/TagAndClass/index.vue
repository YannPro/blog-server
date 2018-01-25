<template>
	<section>
		<el-row :gutter="20">
			 <el-col :span="12" class="clazz">
         <div class="grid-content">
          <div class="header"><p class="title">分类</p></div>
          <el-tag
              v-for="(clazz,index) in clazzList"
              :key="index"
              closable
              :type="clazz.type"
              @close="handleClose(clazz.id,0)">
              {{clazz.className}}
          </el-tag>
          <el-input
            class="input-new-tag"
            v-if="classVisible"
            v-model="inputValue"
            ref="saveClassInput"
            size="small"
            @keyup.enter.native="handleAddConfirm(0)"
            @blur="handleAddConfirm(0)"
          >
          </el-input>
          <el-button v-else class="button-new-tag" size="small" @click="showInput(0)">+ 新建</el-button>

        </div>
			</el-col>
  		<el-col :span="12" class="tag">
        <div class="grid-content">
          <div class="header"><p class="title">标签</p></div>
          <el-tag
              v-for="(tag,index) in tags"
              :key="index"
              closable
              :type="tag.type"
              @close="handleClose(tag.id,1)"
          >
              {{tag.tagName}}
          </el-tag>
          <el-input
            class="input-new-tag"
            v-if="tagVisible"
            v-model="inputValue"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleAddConfirm(1)"
            @blur="handleAddConfirm(1)"
          >
          </el-input>
          <el-button v-else class="button-new-tag" size="small" @click="showInput(1)">+ 新建</el-button>
        </div>
      </el-col>
		</el-row>
	</section>
</template>
<script>
  import { getAllClass, getAllTag, deleteTag, deleteClass,addClass,addTag} from '../../api/api';
  export default {
    data() {
      return {
        tags: [],
        clazzList: [],
        classVisible: false,
        tagVisible: false,
        inputValue: '',
        typeArr: ['success', 'info', 'warning', 'danger', '']
      };
    },
    mounted() {
			this.getData();
		},
    methods:{
      getData(){

        getAllTag().then(result => {
          this.tags = result.data
          for(let tag of this.tags){
            let n = Math.floor(Math.random()*this.typeArr.length);
            tag.type = this.typeArr[n]
          }
        })

        getAllClass().then(result => {
          this.clazzList = result.data
          for(let clazz of this.clazzList){
            let n = Math.floor(Math.random()*this.typeArr.length);
            clazz.type = this.typeArr[n]
          }
        })

      },
      //flag 0表示class  1表示tag
      handleClose(id,flag) {
        this.$confirm('确认删除该标签吗?', '提示', {
					//type: 'warning'
				}).then(() => {
          let param = {
            'id': id
          }
          if(flag === 0){
            deleteClass(param).then(result => {
              this.$notify({
                title: '成功',
                message: '删除成功',
                type: 'success'
              });
              this.getData();
            })
          }else{
            deleteTag(param).then(result => {
              this.$notify({
                title: '成功',
                message: '删除成功',
                type: 'success'
              });
              this.getData();
            })
          }

				});
      },
      /* input出现 可以输入文字 */
      showInput(flag) {
        if(flag === 0){
          this.classVisible = true;
          this.$nextTick(_ => {
            this.$refs.saveClassInput.$refs.input.focus();
          });
        }else{
          this.tagVisible = true;
          this.$nextTick(_ => {
            this.$refs.saveTagInput.$refs.input.focus();
          });
        }
      },
      handleAddConfirm(flag) {
       
        this.$confirm('确认添加该标签吗?', '提示', {
					//type: 'warning'
				}).then(() => {
          console.log("inputvALUE:"+ this.inputValue)
          if (this.inputValue) {
            if(flag === 0){//如果是类目
              let param = {
                'className': this.inputValue
              }
              addClass(param).then( result => {
                console.log(result)
                this.classVisible = false;
                this.inputValue = '';
                this.getData();
              })
            }else{//如果是标签
              let param = {
                'tagName': this.inputValue
              }
              addTag(param).then( result => {
                console.log(result)
                this.tagVisible = false;
                this.inputValue = '';
                this.getData();
              })
            }
            
          }
				});
      }
    }
  }
</script>
<style>
  .tag .header{
    width: 100%;
    height: 40px;
    background: #1f2d3d;
  }
  .clazz .header{
    width: 100%;
    height: 40px;
    background: #000000;
  }
  .header .title{
    color: #fff;
    font-size: 14px;
    padding-top: 10px; 
    padding-left: 10px; 
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
</style>

<template>
	<section id="publish">文章发布页面
		<el-row :gutter="20">
			<el-col :span="12">
          <MDInput name="name" v-model="article.title">
            标题
          </MDInput>
      </el-col>
			<el-col :span="12">
          <MDInput name="name" v-model="article.description">
            摘要
          </MDInput>
      </el-col>
		</el-row>
		<el-row :gutter="20">
			<el-col :span="12">
          <TagsInput element-id="tags"
            :existing-tags="tags"
            :typeahead="true"
            v-model="submitTags"
            >
          </TagsInput>
      </el-col>
      <el-col :span="12">
            <TagsInput element-id="clazz"
            :existing-tags='{"1":"21"}'
            :typeahead="true" 
            v-model="submitClazzList"
            >
          </TagsInput>
        <!-- <TagsInput element-id="tags"
            :existing-tags="{ 
                'web-development': 'Web Development',
                'php': 'PHP',
                'javascript': 'JavaScript',
                'java': 'java',
                'Java22': 'Java22',
            }"
            :typeahead="true">
          </TagsInput> -->
      </el-col>
			<!-- <el-col :span="12"><div class="grid-content bg-purple"></div></el-col> -->
		</el-row>
		<el-row>
			<div class="editor-container">
				<markdown-editor id="contentEditor" ref="contentEditor" v-model="article.content" :height="300" :zIndex="20"></markdown-editor>
			</div>
		</el-row>
    <el-row>
      <el-switch
        v-model="value3"
        inactive-text="开启评论">
      </el-switch>
      <el-switch
        v-model="value4"
        active-color="#13ce66"
        inactive-color="#ff4949"
        inactive-text="按年付费">
      </el-switch>
      <el-switch
        v-model="value5"
        active-color="#13ce66"
        inactive-color="#ff4949"
        inactive-text="按年付费">
      </el-switch>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12" :offset="17">
        <div class="grid-content">
            <el-button>返回列表</el-button>
  <el-button type="primary" @click="handleAddArticle">保存文章</el-button>
  <el-button type="success">存为草稿</el-button>
        </div>
      </el-col>
    </el-row>
	</section>
</template>
<script>
import MarkdownEditor from '../../components/MarkdownEditor'
import MDInput  from '../../components/MDInput'
import TagsInput from '../../components/TagsInput'
import TagsInput2 from '../../components/TagsInput'
import { getAllClass, getAllTag, addArticle} from '../../api/api';

const content = `
**this is test**
* vue
* element
* webpack
## Simplemde
`
export default {
  
  name: 'markdown-demo',
  components: { MarkdownEditor, MDInput, TagsInput,TagsInput2},
  data() {
    return {
      html: '',
      tags: {},
      classList: {},
      submitTags: ["111","222"],
      submitClazzList: [],
      value3: true,
      value4: true,
      value5: true,
      article: {
        content: content,
      }
    }
  },
  mounted(){
    getAllTag().then(res => {
      console.log(res)
      for(let i in res.data){
        this.tags[i] = res.data[i].tagName
      }

      getAllClass().then(res1 => {
      for(let j of res1.data){
        this.classList[j] = res1.data[j].className
        }
      })
    })

  },
  methods: {
    handleAddArticle(){
      this.article.tagList = []
      this.article.classList = []
      for(let tag of this.submitTags){
        this.article.tagList.push({"tagName":tag})
      }
      for(let clazz of this.submitClazzList){
        this.article.classList.push({"className":clazz})
      }
              console.log("!!!",this.article)

    // axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'
// axios.post(`/admin/article`, this.article).then((re11)=>{console.log("!!!!!!!!",res11)})
      addArticle(this.article).then(res=>{
        if(res.status === 1){
          console.log("新增成功")
        }
      })
    }
    // markdown2Html() {
    //   import('showdown').then(showdown => {
    //     const converter = new showdown.Converter()
    //     this.html = converter.makeHtml(this.content)
    //   })
    // }
  }
}
</script>

<style>
  #publish{
    padding: 20px;
  }
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
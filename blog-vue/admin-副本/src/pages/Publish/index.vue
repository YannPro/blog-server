<template>
	<section id="publish">文章发布页面
		<el-row :gutter="20">
			<el-col :span="12"><div class="grid-content bg-purple"></div></el-col>
			<el-col :span="12"><div class="grid-content bg-purple"></div></el-col>
		</el-row>
		<el-row :gutter="20">
			<el-col :span="12"><div class="grid-content bg-purple"></div></el-col>
			<el-col :span="12"><div class="grid-content bg-purple"></div></el-col>
		</el-row>
		<el-row>
			<div class="editor-container">
				<markdown-editor id="contentEditor" ref="contentEditor" v-model="content" :height="300" :zIndex="20"></markdown-editor>
			</div>
		</el-row>
	</section>
</template>
<script>
import MarkdownEditor from '../../components/MarkdownEditor'
const content = `
**this is test**
* vue
* element
* webpack
## Simplemde
`
export default {
  name: 'markdown-demo',
  components: { MarkdownEditor },
  data() {
    return {
      content: content,
      html: ''
    }
  },
  methods: {
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
<template>
	<section id="publish">标签

        <TagsInput element-id="tags"
            :existing-tags="{ 
                'web-development': 'Web Development',
                'php': 'PHP',
                'javascript': 'JavaScript',
            }"
            :typeahead="true">
          </TagsInput>
    </section>
</template>
<script>
import TagsInput from '../../components/TagsInput'
export default {
  name: 'markdown-demo',
  data() {
    return {
      html: ''
    }
  },
  components:{
    TagsInput
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

</style>
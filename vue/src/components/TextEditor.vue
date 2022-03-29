<template>
  <editor-content :editor="editor" />
</template>

<script>
import { Editor, EditorContent } from '@tiptap/vue-3'
import { Node } from '@tiptap/core'
import StarterKit from '@tiptap/starter-kit'

export default {
  components: {
    EditorContent,
  },

  data() {
    return {
      editor: null,
    }
  },

  mounted() {
    const CustomeNode = Node.create({
      
    });
    this.editor = new Editor({
      content: '<p>I’m running Tiptap with Vue.js. 🎉</p>',
      extensions: [
        StarterKit,
        CustomeNode
      ],
    })
  },

  beforeUnmount() {
    this.editor.destroy()
  },
}
</script>
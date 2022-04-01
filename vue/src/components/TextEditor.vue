<template>
  <div class="editor-body">
    
    <div v-if="editor">
    
      <div class="text-editor-btn-area" v-if="toolBar">
        <button @click="editor.chain().focus().toggleBold().run()" :class="{ 'is-active': editor.isActive('bold') }">
          <img src="https://img.icons8.com/fluency-systems-regular/344/bold.png" alt="bold">
        </button>
        <button @click="editor.chain().focus().toggleItalic().run()" :class="{ 'is-active': editor.isActive('italic') }">
          <img src="https://img.icons8.com/material-rounded/344/italic.png" alt="italic">
        </button>
        <button @click="editor.chain().focus().toggleStrike().run()" :class="{ 'is-active': editor.isActive('strike') }">
          <img src="https://img.icons8.com/material-rounded/344/strikethrough.png" alt="strike">
        </button>
        <img src="https://img.icons8.com/material-rounded/344/vertical-line.png" alt="vertical_bar">
        <button @click="editor.chain().focus().toggleHeading({ level: 1 }).run()" :class="{ 'is-active': editor.isActive('heading', { level: 1 }) }">
          <img src="https://img.icons8.com/material-rounded/344/header-1.png" alt="h1">
        </button>
        <button @click="editor.chain().focus().toggleHeading({ level: 2 }).run()" :class="{ 'is-active': editor.isActive('heading', { level: 2 }) }">
          <img src="https://img.icons8.com/material-rounded/344/header-2.png" alt="h2">
        </button>
        <button @click="editor.chain().focus().toggleHeading({ level: 3 }).run()" :class="{ 'is-active': editor.isActive('heading', { level: 3 }) }">
          <img src="https://img.icons8.com/material-rounded/344/header-3.png" alt="h3">
        </button>
        <img src="https://img.icons8.com/material-rounded/344/vertical-line.png" alt="vertical_bar">
        <button @click="editor.chain().focus().toggleBulletList().run()" :class="{ 'is-active': editor.isActive('bulletList') }">
          <img src="https://img.icons8.com/material-rounded/344/list.png" alt="bullet-list">
        </button>
        <button @click="editor.chain().focus().toggleOrderedList().run()" :class="{ 'is-active': editor.isActive('orderedList') }">
          <img src="https://img.icons8.com/material-rounded/344/numbered-list.png" alt="ordered-list">
        </button>
        <img src="https://img.icons8.com/material-rounded/344/vertical-line.png" alt="vertical_bar">
        <button @click="editor.chain().focus().setTextAlign('left').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'left' }) }">
          <img src="https://img.icons8.com/material-rounded/344/align-left.png" alt="left">
        </button>
        <button @click="editor.chain().focus().setTextAlign('center').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'center' }) }">
          <img src="https://img.icons8.com/material-rounded/344/align-center.png" alt="center">
        </button>
        <button @click="editor.chain().focus().setTextAlign('right').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'right' }) }">
          <img src="https://img.icons8.com/material-rounded/344/align-right.png" alt="right">
        </button>
        <button @click="editor.chain().focus().setTextAlign('justify').run()" :class="{ 'is-active': editor.isActive({ textAlign: 'justify' }) }">
          <img src="https://img.icons8.com/material-rounded/344/align-justify.png" alt="justify">
        </button>
    
        <img src="https://img.icons8.com/material-rounded/344/vertical-line.png" alt="vertical_bar">
        <button @click="editor.chain().focus().toggleCodeBlock().run()" :class="{ 'is-active': editor.isActive('codeBlock') }">
          <img src="https://img.icons8.com/material-outlined/344/code.png" alt="code-block">
        </button>
        <button @click="editor.chain().focus().toggleCode().run()" :class="{ 'is-active': editor.isActive('code') }">
          <img src="https://img.icons8.com/material-rounded/344/source-code.png" alt="source">
        </button>
        <button @click="editor.chain().focus().toggleBlockquote().run()" :class="{ 'is-active': editor.isActive('blockquote') }">
          <img src="https://img.icons8.com/material-rounded/344/quote-left.png" alt="block-quote">
        </button>
        <button @click="editor.chain().focus().setHorizontalRule().run()">
          <img src="https://img.icons8.com/material-rounded/344/horizontal-line.png" alt="horizontal-rule">
        </button>
    
        <button @click="addImage">
          <img src="https://img.icons8.com/material-rounded/344/image.png" alt="image">
        </button>
        <img src="https://img.icons8.com/material-rounded/344/vertical-line.png" alt="vertical_bar">
        <input
        class="text-editor-color-peeker"
        type="color"
        @input="editor.chain().focus().setColor($event.target.value).run()"
        :value="editor.getAttributes('textStyle').color">
      </div>
    </div>
    <editor-content ref="textEditor" :editor="editor" class="edit-content"/>
    
  </div>
</template>

<script>
import { Editor, EditorContent } from '@tiptap/vue-3'
import Image from '@tiptap/extension-image'
import StarterKit from '@tiptap/starter-kit'
import TextStyle from '@tiptap/extension-text-style'
import { Color } from '@tiptap/extension-color'
import TextAlign from '@tiptap/extension-text-align'

export default {
  components: {
    EditorContent,
  },

  data() {
    return {
      editor: null,
      contents: '',
      toolBar: true
      
    }
  },

  methods: {
    addImage() {
      const url = window.prompt('URL')

      if (url) {
        this.editor.chain().focus().setImage({ src: url }).run()
      }
    },
    sendContents() {
      var contents = this.editor.getHTML();
      this.$emit('sendContents', contents);
    }
  },

  mounted() {
    this.editor = new Editor({
      extensions: [
        StarterKit,
        Image,
        Color,
        TextStyle,
        TextAlign.configure({
          types: ['heading', 'paragraph'],
        }),
      ],
      content: this.contents
    })
  },

  beforeUnmount() {
    this.editor.destroy()
  },
}
</script>

<style lang="scss">
.text-editor-btn-area {
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 5px;
  border-bottom: 1px solid black;
  padding-bottom: 10px;
}
.text-editor-btn-area > img {
  width: 30px;
  height: 40px; 
}
.text-editor-btn-area button {
  background: white;
  border: none;
  border-radius: 5px;
  margin: 0 2px;
  padding-top: 5px;
  font-size: 16px;
  font-weight: bold;
  flex-grow: 1;
}
button img {
  width: 24px;
  height: 24px;
  object-fit: cover;
}

.text-editor-color-peeker {
  width: 50px;
  height: 40px;
  background: white;
  border: none;
  margin: 0 2px;
  padding: 3px;
}

// 에디터 관련 구간 
.ProseMirror{

  padding: 20px;
  height: 370px;
  overflow: scroll;

> * + * {
    margin-top: 0.75em;
  }

  ul,
  ol {
    padding: 0 1rem;
  }

  h1,
  h2,
  h3,
  h4,
  h5,
  h6 {
    line-height: 1.1;
  }

  code {
    background-color: rgba(#616161, 0.1);
    color: #616161;
  }

  pre {
    background: #0D0D0D;
    color: #FFF;
    font-family: 'AlegreyaSans', sans-serif;
    padding: 0.75rem 1rem;
    border-radius: 0.5rem;

    code {
      color: inherit;
      padding: 0;
      background: none;
      font-size: 0.8rem;
    }

  }

  img {
    max-width: 100%;
    height: auto;
  }

  blockquote {
    padding-left: 1rem;
    border-left: 2px solid rgba(#0D0D0D, 0.1);
  }

  hr {
    border: none;
    border-top: 2px solid rgba(#0D0D0D, 0.1);
    margin: 2rem 0;
  }

}
.edit-content *:focus {
  outline: none;
}

</style>
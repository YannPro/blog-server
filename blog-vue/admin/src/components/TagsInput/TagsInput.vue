<template>
    <div>
        <div class="form-control tags-input">
            <span class="badge badge-pill badge-light"
                v-for="(badge, index) in tagBadges"
                :key="index"
            >
                <span v-html="badge"></span>

                <i href="#" class="tagsinput-remove" @click.prevent="removeTag(index)"></i>
            </span>

            <input type="text"
                placeholder="新增"
                v-model="input"
                @keypress.enter.prevent="tagFromInput"
                @keypress.backspace="removeLastTag"
                @keypress.down="nextSearchResult"
                @keypress.up="prevSearchResult"
                @keypress.esc="ignoreSearchResults"
                @keyup="searchTag">

            <input type="hidden" :name="elementId" :id="elementId" v-model="hiddenInput">
        </div>

        <p v-show="searchResults.length" class="typeahead">
            <span v-for="(tag, index) in searchResults"
                :key="index"
                v-text="tag.text"
                @click="tagFromSearch(tag)"
                class="badge"
                v-bind:class="{
                    'badge-primary': index == searchSelection,
                    'badge-dark': index != searchSelection
                }"></span>
        </p>
    </div>
</template>

<script>
export default {
    props: ['elementId', 'existingTags', 'oldTags', 'typeahead'],

    data() {
        return {
            badgeId: 0,
            tagBadges: [],
            tags: [],
            input: '',
            oldInput: '',
            hiddenInput: '',
            searchResults: [],
            searchSelection: 0,
        };
    },

    created() {
        if (this.oldTags && this.oldTags.length) {
            let oldTags = Array.isArray(this.oldTags)
                ? this.oldTags
                : this.oldTags.split(',');

            for (let slug of oldTags) {
                let existingTag = this.existingTags[slug];
                let text = existingTag ? existingTag : slug;

                this.addTag(slug, text);
            }
        }
    },

    watch: {
        tags() {
            // Updating the hidden input
            this.hiddenInput = this.tags.join(',');
        }
    },

    methods: {
        tagFromInput(e) {
            // If we're choosing a tag from the search results
            if (this.searchResults.length && this.searchSelection >= 0) {
                this.tagFromSearch(this.searchResults[this.searchSelection]);

                this.input = '';
            } else {
                let text = this.input.trim();

                // If the new tag is not an empty string
                if (text.length) {
                    this.input = '';

                    // Determine the tag's slug and text depending on if the tag exists
                    // on the site already or not
                    let slug = this.makeSlug(text);
                    let existingTag = this.existingTags[slug];

                    slug = existingTag ? slug : text;
                    text = existingTag ? existingTag : text;

                    this.addTag(slug, text);
                }
            }
        },

        tagFromSearch(tag) {
            this.searchResults = [];
            this.input = '';
            
            this.addTag(tag.slug, tag.text);
        },

        makeSlug(value) {
            return value.toLowerCase().replace(/\s/g, '-');
        },

        addTag(slug, text) {
            // Attach the tag if it hasn't been attached yet
            let searchSlug = this.makeSlug(slug);
            let found = this.tags.find((value) => {
                return searchSlug == this.makeSlug(value);
            });

            if (!found) {
                this.tagBadges.push(text.replace(/\s/g, '&nbsp;'));
                this.tags.push(slug);
            }
        },

        removeLastTag(e) {
            if (!e.target.value.length) {
                this.removeTag(this.tags.length - 1);
            }
        },

        removeTag(index) {
            this.tags.splice(index, 1);
            this.tagBadges.splice(index, 1);
        },

        searchTag(e) {
            if (this.typeahead === true) {
                if (this.oldInput != this.input) {
                    this.searchResults = [];
                    this.searchSelection = 0;
                    let input = this.input.trim();

                    if (input.length) {
                        for (let slug in this.existingTags) {
                            let text = this.existingTags[slug].toLowerCase();

                            if (text.search(input.toLowerCase()) > -1) {
                                this.searchResults.push({ slug, text: this.existingTags[slug] });
                            }
                        }
                    }

                    this.oldInput = this.input;
                }
            }
        },

        nextSearchResult() {
            if (this.searchSelection + 1 <= this.searchResults.length - 1) {
                this.searchSelection++;
            }
        },

        prevSearchResult() {
            if (this.searchSelection > 0) {
                this.searchSelection--;
            }
        },

        ignoreSearchResults() {
            this.searchResults = [];
            this.searchSelection = 0;
        }
    }
}
</script>

<style scoped>
/* tagsinput */
.tags-input {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
}

.tags-input input {
    flex: 1;
    background: transparent;
    border: none;
}

.tags-input span {
    margin-right: 0.3rem;
    margin-bottom: 0.2rem;
}

.tagsinput-remove {
    cursor: pointer;
    position: relative;
    display: inline-block;
    width: 0.5rem;
    height: 0.5rem;
    overflow: hidden;
}

.tagsinput-remove:before, .tagsinput-remove:after {
    content: '';
    position: absolute;
    width: 100%;
    top: 50%;
    left: 0;
    background: #5dc282;

    height: 2px;
    margin-top: -1px;
}

.tagsinput-remove:before {
    transform: rotate(45deg);
}
.tagsinput-remove:after {
    transform: rotate(-45deg);
}

.typeahead > span {
    cursor: pointer;
    margin-right: 0.3rem;
}
.form-control {
  display: block;
  width: 100%;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.form-control::-ms-expand {
  background-color: transparent;
  border: 0;
}

.form-control:focus {
  color: #495057;
  background-color: #fff;
  border-color: #80bdff;
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}

.form-control::-webkit-input-placeholder {
  color: #868e96;
  opacity: 1;
}

.form-control:-ms-input-placeholder {
  color: #868e96;
  opacity: 1;
}

.form-control::-ms-input-placeholder {
  color: #868e96;
  opacity: 1;
}

.form-control::placeholder {
  color: #868e96;
  opacity: 1;
}

.form-control:disabled, .form-control[readonly] {
  background-color: #e9ecef;
  opacity: 1;
}

.badge {
  display: inline-block;
  padding: 0.25em 0.4em;
  font-size: 75%;
  font-weight: 700;
  line-height: 1;
  text-align: center;
  white-space: nowrap;
  vertical-align: baseline;
  border-radius: 0.25rem;
}

.badge:empty {
  display: none;
}

.badge-pill {
  padding-right: 0.6em;
  padding-left: 0.6em;
  border-radius: 10rem;
}

.badge-primary {
  color: #fff;
  background-color: #007bff;
}

.badge-primary[href]:focus, .badge-primary[href]:hover {
  color: #fff;
  text-decoration: none;
  background-color: #0062cc;
}

.badge-light {
  color: #212529;
  background-color: #f8f9fa;
}

.badge-light[href]:focus, .badge-light[href]:hover {
  color: #212529;
  text-decoration: none;
  background-color: #dae0e5;
}

.badge-dark {
  color: #fff;
  background-color: #343a40;
}

.badge-dark[href]:focus, .badge-dark[href]:hover {
  color: #fff;
  text-decoration: none;
  background-color: #1d2124;
}
</style>
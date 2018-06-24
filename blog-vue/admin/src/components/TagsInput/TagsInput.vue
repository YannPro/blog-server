<template>
    <div>
        <div :class="inputClass + ' tags-input'">
            <span class="badge badge-pill badge-light"
                v-for="(badge, index) in tagBadges"
                :key="index"
            >
                <span v-html="badge"></span>

                <i href="#" class="tags-input-remove" @click.prevent="removeTag(index)"></i>
            </span>

            <input type="text"
                :placeholder="placeholder"
                v-model="input"
                @keydown.enter.prevent="tagFromInput"
                @keydown.8="removeLastTag"
                @keydown.down="nextSearchResult"
                @keydown.up="prevSearchResult"
                @keyup.esc="ignoreSearchResults"
                @keyup="searchTag"
                @value="tags">

            <input type="hidden" v-if="elementId" 
                :name="elementId"
                :id="elementId"
                v-model="hiddenInput">
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
    props: {
        elementId: String,
        inputClass: {
            type: String,
            default: 'tags-input-default-class'
        },
        existingTags: {
            type: Object,
            default: () => {
                return {};
            }
        },
        value: {
            type: [Array, String],
            default: () => {
                return [];
            }
        },
        
        typeahead: {
            type: Boolean,
            default: false
        },
        placeholder: {
            type: String,
            default: 'Add a tag'
        },
        limit: {
            type: Number,
            default: 0
        },
        onlyExistingTags: {
            type: Boolean,
            default: false
        },
        
        deleteOnBackspace: {
            type: Boolean,
            default: true
        },
    },
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
    created () {
        this.tagsFromValue();
    },
    watch: {
        tags() {
            // Updating the hidden input
            this.hiddenInput = this.tags.join(',');
            // Update the bound v-model value
            this.$emit('input', this.tags);
        },
        value() {
            this.tagsFromValue();
        }
    },
    methods: {
        tagFromInput(e) {
            // If we're choosing a tag from the search results
            if (this.searchResults.length && this.searchSelection >= 0) {
                this.tagFromSearch(this.searchResults[this.searchSelection]);
                this.input = '';
            } else {
                // If we're adding an unexisting tag
                let text = this.input.trim();
                // If the new tag is not an empty string
                if (!this.onlyExistingTags && text.length) {
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
            this.oldInput = '';
            
            this.addTag(tag.slug, tag.text);
        },
        makeSlug(value) {
            return value.toLowerCase().replace(/\s/g, '-');
        },
        addTag(slug, text) {
            // Check if the limit has been reached
            if (this.limit > 0 && this.tags.length >= this.limit) {
                return false;
            }
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
            if (!e.target.value.length && this.deleteOnBackspace) {
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
                        // Sort the search results alphabetically
                        this.searchResults.sort((a, b) => {
                            if (a.text < b.text) return -1;
                            if (a.text > b.text) return 1;
                            return 0;
                        });
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
        },
        /**
        * Clear the list of selected tags
        */
        clearTags() {
            this.tags.splice(0, this.tags.length);
            this.tagBadges.splice(0, this.tagBadges.length);
        },
        /**
        * Replace the currently selected tags with the tags from the value
        */
        tagsFromValue() {
            if (this.value && this.value.length) {
                let tags = Array.isArray(this.value)
                    ? this.value
                    : this.value.split(',');
                if (this.tags == tags) {
                    return;
                }
                this.clearTags();
                for (let slug of tags) {
                    let existingTag = this.existingTags[slug];
                    let text = existingTag ? existingTag : slug;
                    this.addTag(slug, text);
                }
            } else {
                if (this.tags.length == 0) {
                    return;
                }
                this.clearTags();
            }
        }
    }
}
</script>

<style>
/* tags-input */
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
.typeahead > span {
    cursor: pointer;
    margin-right: 0.3rem;
}
/**
* Copied from Bootstrap 4
*/
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

/**
* Original styles
*/
.tags-input-default-class {
    padding: .5rem .25rem;

    background: #fff;

    border: 1px solid transparent;
    border-radius: .25rem;
    border-color: #dbdbdb;
}

.tags-input-remove {
    cursor: pointer;
    position: relative;
    display: inline-block;
    width: 0.5rem;
    height: 0.5rem;
    overflow: hidden;
}

.tags-input-remove:before, .tags-input-remove:after {
    content: '';
    position: absolute;
    width: 100%;
    top: 50%;
    left: 0;
    background: #5dc282;
    
    height: 2px;
    margin-top: -1px;
}

.tags-input-remove:before {
    transform: rotate(45deg);
}
.tags-input-remove:after {
    transform: rotate(-45deg);
}

.tags-input input:focus {
    outline: none;
}
</style>
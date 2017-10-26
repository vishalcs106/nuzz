package com.example.nuzz.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vishal on 26-10-2017.
 */

public class NewsResponse {

    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;
    @SerializedName("nbHits")
    @Expose
    private Integer nbHits;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("nbPages")
    @Expose
    private Integer nbPages;
    @SerializedName("hitsPerPage")
    @Expose
    private Integer hitsPerPage;
    @SerializedName("processingTimeMS")
    @Expose
    private Integer processingTimeMS;
    @SerializedName("exhaustiveNbHits")
    @Expose
    private Boolean exhaustiveNbHits;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("params")
    @Expose
    private String params;

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public Integer getNbHits() {
        return nbHits;
    }

    public void setNbHits(Integer nbHits) {
        this.nbHits = nbHits;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public Integer getHitsPerPage() {
        return hitsPerPage;
    }

    public void setHitsPerPage(Integer hitsPerPage) {
        this.hitsPerPage = hitsPerPage;
    }

    public Integer getProcessingTimeMS() {
        return processingTimeMS;
    }

    public void setProcessingTimeMS(Integer processingTimeMS) {
        this.processingTimeMS = processingTimeMS;
    }

    public Boolean getExhaustiveNbHits() {
        return exhaustiveNbHits;
    }

    public void setExhaustiveNbHits(Boolean exhaustiveNbHits) {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }




    public class Hit {

        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("points")
        @Expose
        private Integer points;
        @SerializedName("story_text")
        @Expose
        private Object storyText;
        @SerializedName("comment_text")
        @Expose
        private Object commentText;
        @SerializedName("num_comments")
        @Expose
        private Integer numComments;
        @SerializedName("story_id")
        @Expose
        private Object storyId;
        @SerializedName("story_title")
        @Expose
        private Object storyTitle;
        @SerializedName("story_url")
        @Expose
        private Object storyUrl;
        @SerializedName("parent_id")
        @Expose
        private Object parentId;
        @SerializedName("created_at_i")
        @Expose
        private Integer createdAtI;
        @SerializedName("_tags")
        @Expose
        private List<String> tags = null;
        @SerializedName("objectID")
        @Expose
        private String objectID;
        @SerializedName("_highlightResult")
        @Expose
        private HighlightResult highlightResult;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public Object getStoryText() {
            return storyText;
        }

        public void setStoryText(Object storyText) {
            this.storyText = storyText;
        }

        public Object getCommentText() {
            return commentText;
        }

        public void setCommentText(Object commentText) {
            this.commentText = commentText;
        }

        public Integer getNumComments() {
            return numComments;
        }

        public void setNumComments(Integer numComments) {
            this.numComments = numComments;
        }

        public Object getStoryId() {
            return storyId;
        }

        public void setStoryId(Object storyId) {
            this.storyId = storyId;
        }

        public Object getStoryTitle() {
            return storyTitle;
        }

        public void setStoryTitle(Object storyTitle) {
            this.storyTitle = storyTitle;
        }

        public Object getStoryUrl() {
            return storyUrl;
        }

        public void setStoryUrl(Object storyUrl) {
            this.storyUrl = storyUrl;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public Integer getCreatedAtI() {
            return createdAtI;
        }

        public void setCreatedAtI(Integer createdAtI) {
            this.createdAtI = createdAtI;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getObjectID() {
            return objectID;
        }

        public void setObjectID(String objectID) {
            this.objectID = objectID;
        }

        public HighlightResult getHighlightResult() {
            return highlightResult;
        }

        public void setHighlightResult(HighlightResult highlightResult) {
            this.highlightResult = highlightResult;
        }

    }




    private class HighlightResult {

        @SerializedName("title")
        @Expose
        private Title title;
        @SerializedName("url")
        @Expose
        private Url url;
        @SerializedName("author")
        @Expose
        private Author author;

        public Title getTitle() {
            return title;
        }

        public void setTitle(Title title) {
            this.title = title;
        }

        public Url getUrl() {
            return url;
        }

        public void setUrl(Url url) {
            this.url = url;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

    }


    private class Title {

        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("matchLevel")
        @Expose
        private String matchLevel;
        @SerializedName("fullyHighlighted")
        @Expose
        private Boolean fullyHighlighted;
        @SerializedName("matchedWords")
        @Expose
        private List<String> matchedWords = null;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMatchLevel() {
            return matchLevel;
        }

        public void setMatchLevel(String matchLevel) {
            this.matchLevel = matchLevel;
        }

        public Boolean getFullyHighlighted() {
            return fullyHighlighted;
        }

        public void setFullyHighlighted(Boolean fullyHighlighted) {
            this.fullyHighlighted = fullyHighlighted;
        }

        public List<String> getMatchedWords() {
            return matchedWords;
        }

        public void setMatchedWords(List<String> matchedWords) {
            this.matchedWords = matchedWords;
        }

    }




    private class Url {

        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("matchLevel")
        @Expose
        private String matchLevel;
        @SerializedName("fullyHighlighted")
        @Expose
        private Boolean fullyHighlighted;
        @SerializedName("matchedWords")
        @Expose
        private List<String> matchedWords = null;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMatchLevel() {
            return matchLevel;
        }

        public void setMatchLevel(String matchLevel) {
            this.matchLevel = matchLevel;
        }

        public Boolean getFullyHighlighted() {
            return fullyHighlighted;
        }

        public void setFullyHighlighted(Boolean fullyHighlighted) {
            this.fullyHighlighted = fullyHighlighted;
        }

        public List<String> getMatchedWords() {
            return matchedWords;
        }

        public void setMatchedWords(List<String> matchedWords) {
            this.matchedWords = matchedWords;
        }

    }



    private class Author {

        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("matchLevel")
        @Expose
        private String matchLevel;
        @SerializedName("matchedWords")
        @Expose
        private List<Object> matchedWords = null;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMatchLevel() {
            return matchLevel;
        }

        public void setMatchLevel(String matchLevel) {
            this.matchLevel = matchLevel;
        }

        public List<Object> getMatchedWords() {
            return matchedWords;
        }

        public void setMatchedWords(List<Object> matchedWords) {
            this.matchedWords = matchedWords;
        }

    }

}

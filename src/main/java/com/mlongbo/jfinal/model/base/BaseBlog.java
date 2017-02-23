package com.mlongbo.jfinal.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public M setUserId(java.lang.Integer userId) {
		set("user_id", userId);
		return (M)this;
	}

	public java.lang.Integer getUserId() {
		return get("user_id");
	}

	public M setTitle(java.lang.String title) {
		set("title", title);
		return (M)this;
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public M setContent(java.lang.String content) {
		set("content", content);
		return (M)this;
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public M setContentShow(java.lang.String contentShow) {
		set("content_show", contentShow);
		return (M)this;
	}

	public java.lang.String getContentShow() {
		return get("content_show");
	}

	public M setKeyword(java.lang.String keyword) {
		set("keyword", keyword);
		return (M)this;
	}

	public java.lang.String getKeyword() {
		return get("keyword");
	}

	public M setIspublic(java.lang.Integer ispublic) {
		set("ispublic", ispublic);
		return (M)this;
	}

	public java.lang.Integer getIspublic() {
		return get("ispublic");
	}

	public M setDeleted(java.lang.Integer deleted) {
		set("deleted", deleted);
		return (M)this;
	}

	public java.lang.Integer getDeleted() {
		return get("deleted");
	}

	public M setCategory(java.lang.Integer category) {
		set("category", category);
		return (M)this;
	}

	public java.lang.Integer getCategory() {
		return get("category");
	}

	public M setView(java.lang.Integer view) {
		set("view", view);
		return (M)this;
	}

	public java.lang.Integer getView() {
		return get("view");
	}

	public M setType(java.lang.Integer type) {
		set("type", type);
		return (M)this;
	}

	public java.lang.Integer getType() {
		return get("type");
	}

	public M setImage(java.lang.String image) {
		set("image", image);
		return (M)this;
	}

	public java.lang.String getImage() {
		return get("image");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
		return (M)this;
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public M setZhuanzai(java.lang.Integer zhuanzai) {
		set("zhuanzai", zhuanzai);
		return (M)this;
	}

	public java.lang.Integer getZhuanzai() {
		return get("zhuanzai");
	}

	public M setZhuanzaiurl(java.lang.String zhuanzaiurl) {
		set("zhuanzaiurl", zhuanzaiurl);
		return (M)this;
	}

	public java.lang.String getZhuanzaiurl() {
		return get("zhuanzaiurl");
	}

	public M setEditortype(java.lang.Integer editortype) {
		set("editortype", editortype);
		return (M)this;
	}

	public java.lang.Integer getEditortype() {
		return get("editortype");
	}

	public M setLevel(java.lang.Integer level) {
		set("level", level);
		return (M)this;
	}

	public java.lang.Integer getLevel() {
		return get("level");
	}

	public M setShowside(java.lang.Integer showside) {
		set("showside", showside);
		return (M)this;
	}

	public java.lang.Integer getShowside() {
		return get("showside");
	}

}
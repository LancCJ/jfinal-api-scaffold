#sql("updateBlogViewCount")
  update blog set view=(view+1) where id=?
#end
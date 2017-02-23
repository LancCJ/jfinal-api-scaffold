#sql("listMsg")
  SELECT * FROM blog order by create_time desc limit (#p(pageNum)-1)*#p(pageSize),#p(pageSize)
#end
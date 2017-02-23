#sql("checkUser")
  SELECT * FROM user WHERE userName=#p(userName)
#end
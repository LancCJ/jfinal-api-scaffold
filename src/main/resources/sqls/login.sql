#sql("login")
  SELECT * FROM user WHERE userName=#p(userName) AND password=#p(password)
#end
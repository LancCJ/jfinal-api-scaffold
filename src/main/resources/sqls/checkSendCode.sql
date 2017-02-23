#sql("checkSendCode")
  SELECT * FROM register_code WHERE mobile=#p(userName)
#end
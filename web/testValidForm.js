test("Accepts Emails", function () {
ok("This email should be ok", ValdiateForm("At@.com", true))
ok("This is an valid email", ValdiateForm("123_g-g@google.com", true))
ok("This is not an valid email, ", ValidateFrom("123ggg", true).se == false)
}
test("Empty Strings", function() {
equals("empty String shoud not pass", ValidateForm("", false), false)
equals("something less ovbvious", ValidateFrom("S", false), true)
}


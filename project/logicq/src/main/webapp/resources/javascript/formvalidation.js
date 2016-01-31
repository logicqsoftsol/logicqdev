$(document).ready(function() {

					generateCaptcha();

					$('#signupForm')
							.bootstrapValidator(
									{

										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										excluded : ':disabled',
										fields : {
											firstname : {
												validators : {
													notEmpty : {
														message : 'First Name is required and cannot be empty'
													},
													regexp : {
														regexp : /^[A-Za-z\s.'-]+$/,
														message : "Alphabetical characters, hyphens and spaces"
													}
												}
											},
											lastname : {
												validators : {
													notEmpty : {
														message : 'Last Name is required and cannot be empty'
													},
													regexp : {
														regexp : /^[A-Za-z\s.'-]+$/,
														message : "Alphabetical characters, hyphens and spaces"
													}
												}
											},
											email : {
												validators : {
													notEmpty : {
														message : 'Email address is required and cannot be empty'
													},
													emailAddress : {
														message : 'The email address is not valid'
													}
												}
											},
											mobilenumber : {
												validators : {
													notEmpty : {
														message : 'Mobile Number is required and cannot be empty'
													},
													regexp : {
														regexp : /^[1-9][0-9]{0,9}$/,
														message : "Invalid Mobile Number"
													},
													stringLength : {
														min : 10,
														message : 'Enter valid mobile number'
													}
												}
											},
											password : {
												validators : {
													notEmpty : {
														message : 'Password is required and cannot be empty'
													},
													stringLength : {
														min : 8,
														message : 'Password minimu contain 8 characters'
													}
												}
											},
											confirmpassword : {
												validators : {
													notEmpty : {
														message : 'Confirm Password is required and cannot be empty'
													},
													identical : {
														field : 'password',
														message : 'The password and its confirm are not the same'
													}
												}
											},
											dob : {
												// The hidden input will not be
												// ignored
												excluded : false,
												validators : {
													notEmpty : {
														message : 'The date is required'
													},
													date : {
														format : 'MM/DD/YYYY',
														message : 'The date is not a valid'
													}
												}
											},

											captcha : {
												validators : {
													callback : {
														message : 'Wrong answer',
														callback : function(
																value,
																validator,
																$field) {
															var items = $(
																	'#captchaOperation')
																	.html()
																	.split(' '), sum = parseInt(items[0])
																	+ parseInt(items[2]);
															return value == sum;
														}
													}
												}
											}
										}
									}).on('err.form.fv', function(e) {
								generateCaptcha();
							});
				});

function randomNumber(min, max) {
	return Math.floor(Math.random() * (max - min + 1) + min);
}
function generateCaptcha() {
	$('#captchaOperation').html(
			[ randomNumber(1, 100), '+', randomNumber(1, 200), '=' ].join(' '));
}

Then(/^I click on "([^"]*)" in blue menu bar$/) do |item|
  $driver.find_element(:xpath, "//*[@id='cssmenu2']//*[contains(text(),'#{item}')]").click
end


And(/^Search results should be present$/) do
  $driver.find_element(:xpath,".//*[@id='post-4222']").displayed?
end

Then(/^I select "([^"]*)" from locations dropdownlist$/) do |location|
  $driver.find_element(:xpath,"//*[@name='project_location_cat']//*[contains(text(),'#{location}')]").click
end

And(/^Location marker should contanis text "([^"]*)"$/) do |country|
  locat = $driver.find_element(:xpath,"//div[@class='bid_panel_front']").text
  p locat
  assert(locat.include?("#{country}"), "Location is not correct! Expected:#{contry}. Found: #{locat}")
end

And(/^I verify all search results are correct$/) do
  amoutn_results = $driver.find_element(:xpath,"//*[@class='widget-title']").text
  p amoutn_results
end

Then(/^I select "([^"]*)" from categories dropdownlist$/) do |category|
 $driver.find_element(:xpath,"//*[@name='project_cat_cat']//*[contains(text(),'#{category}')]").click
end


And(/^I verify "([^"]*)" search results$/) do |cat1|
  cat = $driver.find_element(:xpath, "//div[@class='bid_panel_front']").text
  p cat
  assert(cat.include?("#{cat1}"),"Category is not correct")
end

Then(/^I enter "([^"]*)" in rating field and click search$/) do |rating|
  $driver.find_element(:xpath, "//*[@name='rating_over']").send_keys rating
  Sdriver.find_element(:xpath, "//*[@name='search_provider']").click
end

And(/^I verify user page has correct content$/) do
  eng_name = $driver.find_element(:xpath, "//div[@class='mm_inn']").text
  p eng_name
  cont_name = $driver.find_element(:xpath, "(//*[@class='avatar-posted-by-username'])[1]").text
  p cont_name
  assert(eng_name.include(cont_name),"Content is incorrect")
end

@project_search
  Feature: working on project search



    @c1647
    Scenario: verify that the search function is working
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I click on element having xpath "//*[@rel='projects']"
      Then I enter "a" into input field having xpath "//*[@id='my-top-submit-input']"
      Then I wait for 5 sec
      Then element having xpath "//*[@id='content']" should be present

    @T45737
    Scenario: verify that user can do refine search using keywords
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I enter "d" into input field having xpath ".//*[@name='term']"
      Then I click on element having xpath "//*[@name='ref-search']"
      #And Search results should be present


    @T45735
    Scenario: Verify that user can do refine search using Location.
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I select "United States" from locations dropdownlist
      Then I wait for 3 sec
      Then I click on element having xpath "//*[@name='ref-search']"
      Then I wait for 3 sec
      And I verify all search results are correct
      #Then I click on element having xpath "(//*[@class='green_btn old_mm_k'])[1]"
      #And Location marker should contanis text "United States"


    @T45736
    Scenario: Verify that user can do refine search using Category
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I select "Black Box" from categories dropdownlist
      Then I wait for 3 sec
      Then I click on element having xpath "//*[@name='ref-search']"
      Then I click on element having xpath "(//*[@id='post-4269']//*[contains(text(),'Read More')])[1]"
      And I verify "Black Box" search results


    @T45770
    Scenario: Verify that the user can sort projects using Featured checkbox
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I select checkbox featured
      Then I click on element having xpath "//*[@name='ref-search']"
      And element having xpath "//*[@class='post-title']//*[contains(text(),'Featured Project')]" should be present



    @T45795
    Scenario: Verify that user can cearsh for QA engineer
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirkikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I click on element having xpath "//*[@rel='freelancers']"
      Then I enter "a" into input field having xpath "//*[@id='my-top-submit-input']"
      Then I wait for 5 sec
      And element having xpath "//*[@id='content']" should be present

    @T45799
    Scenario: Verify that "QA Engineer Search" works correctly using Rating Over
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "QA Engineer Search" in blue menu bar
      Then I enter "2" in rating field and click search
      And element having xpath "//*[@class='box_content']" should be present

    @T45804
      Scenario: Verify that when the user clicks on the button Find you Project the page Project Search opens
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Home" in blue menu bar
      Then I click on element having xpath "//*[@id='slide-4-layer-3']"
      And element having xpath "//*[@class='mm_inn']" should have text as "Project Search"

    @T45805
    Scenario: Verify the functionality of Next page button for the Project Search page
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I scroll to end of page
      Then I click on element having xpath ".//*[@id='content']//*[contains(text(),'Next')]"
      Then I wait for 3 sec
      And element having xpath ".//*[@id='activees']" should have text as "2"



    @T45806
    Scenario: Verify the functionality of Previous page button for the Project Search page
      Given I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "12345678"
      Then I click on "Project Search" in blue menu bar
      Then I scroll to end of page
      Then I click on element having xpath "//*[@id='content']//*[contains(text(),'3')]"
      #Then I wait for 3 sec
      #Then I click on element having xpath "//*[@id='content']//*[contains(text(),'Previous')]"
      #And element having xpath "//*[@id='activees']" should have text as "2"









      
      


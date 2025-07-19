package acharya.ajay.ajayacharyaandroid_smartcity_app

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SmartCityAppUnitTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun smartCityHubScreen_displaysTitleAndSections() {
        composeTestRule.setContent {
            SmartCityHubScreen()
        }

        // Check for screen title
        composeTestRule.onNodeWithText("Smart City Hub").assertIsDisplayed()

        // Check for Quick Stats section
        composeTestRule.onNodeWithText("Quick Stats").assertIsDisplayed()

        // Check for City Alerts section
        composeTestRule.onNodeWithText("City Alerts").assertIsDisplayed()
    }

    @Test
    fun quickStatCards_areDisplayed() {
        composeTestRule.setContent {
            SmartCityHubScreen()
        }

        composeTestRule.onNodeWithText("21°").assertIsDisplayed()
        composeTestRule.onNodeWithText("AQI").assertIsDisplayed()
        composeTestRule.onNodeWithText("Traffic").assertIsDisplayed()
    }

    @Test
    fun serviceCards_areDisplayed() {
        composeTestRule.setContent {
            SmartCityHubScreen()
        }

        composeTestRule.onNodeWithText("Public Transport").assertIsDisplayed()
        composeTestRule.onNodeWithText("Emergency Services").assertIsDisplayed()
        composeTestRule.onNodeWithText("Waste Mgmt.").assertIsDisplayed()
        composeTestRule.onNodeWithText("City Events").assertIsDisplayed()
    }

    @Test
    fun cityAlerts_areDisplayed() {
        composeTestRule.setContent {
            SmartCityHubScreen()
        }

        composeTestRule.onNodeWithText("Road Closure").assertIsDisplayed()
        composeTestRule.onNodeWithText("Severe Weather").assertIsDisplayed()
        composeTestRule.onNodeWithText("Power Outage").assertIsDisplayed()
    }
}

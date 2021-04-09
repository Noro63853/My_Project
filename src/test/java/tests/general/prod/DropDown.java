package tests.general.prod;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DropDown extends BaseTest {

    @BeforeMethod
    public void openDropDowns(){
        esportsPage
                .openOddTypes()
                .openMarketFilter()
                .openTimeFilter();
    }

    @Test(description = "WB-145 : External click for drop-downs")
    public void externalClickForDropDowns() {
        esportsPage.clickOnEmptySpace();
        Assert.assertEquals(esportsPage.getOddTypeClass(),esportsPage.CLOSED_DROP_DOWN_CLASS);
        Assert.assertEquals(esportsPage.getMarketFilterClass(),esportsPage.CLOSED_DROP_DOWN_CLASS);
        Assert.assertEquals(esportsPage.getTimeFilterClass(),esportsPage.CLOSED_DROP_DOWN_CLASS);
        System.out.println(headerPage.text().getText());
    }
}

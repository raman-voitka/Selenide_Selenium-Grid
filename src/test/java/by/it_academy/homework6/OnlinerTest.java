package by.it_academy.homework6;

import by.it_academy.homework6.navigation.HomePageNavigation;
import by.it_academy.homework6.pageobject.CatalogPage;
import by.it_academy.homework6.pageobject.Header;
import by.it_academy.homework6.pageobject.ProductPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerTest {

    private Header onlinerHeader = new Header();
    private CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToOnliner() {
        HomePageNavigation.openHomePage("https://www.onliner.by/");
    }

    @BeforeEach
    public void navigateToCatalogOfOnliner() {
        onlinerHeader.clickOnMainNavigationLink("Каталог");
    }

    @DisplayName("Test That Every Category Of Catalog Is Not Empty")
    @Test
    public void testEveryCategoryOfCatalogIsNotEmpty() {
        assertThat(catalogPage.getElementsInsideCategory(catalogPage.getCatalogClassifierLinks()))
                .noneMatch(Objects::isNull);
    }

    @DisplayName("Test That Category 'Computers And Nets' Contains Four Preset Elements")
    @Test
    public void testCategory_ComputersAndNets_HasFourPresetElements() {
        List<String> categoriesOfComputersAndNets = navigateToCategoryComputersAndNets()
                .getElementsInsideCategory(catalogPage.getCategoriesInsideOfComputersAndNets());
        assertThat(categoriesOfComputersAndNets)
                .anyMatch(n -> n.equals("Ноутбуки, компьютеры, мониторы"))
                .anyMatch(n -> n.equals("Комплектующие"))
                .anyMatch(n -> n.equals("Хранение данных"))
                .anyMatch(n -> n.equals("Сетевое оборудование"));
    }

    @DisplayName("Test That Products And Their Descriptions Of Category 'Accessories' Are Not Empty")
    @Test
    public void testProductsAndDescriptionsOfAccessoriesAreNotEmpty() {
        List<String> productsAndDescriptionsOfAccessories = navigateToCategoryComputersAndNets()
                .selectCategory("Комплектующие")
                .getElementsInsideCategory(ProductPage.PRODUCTS_INSIDE_OF_ACCESSORIES);
        assertThat(productsAndDescriptionsOfAccessories)
                .noneMatch(Objects::isNull);
    }

    private CatalogPage navigateToCategoryComputersAndNets() {
        return catalogPage.clickOnCatalogClassifierLink("Компьютеры и\u00A0сети");
    }

}
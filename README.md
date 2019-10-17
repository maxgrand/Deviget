# Deviget
######################  Instructions on running the test  ######################

- Open Intellij or related IDE
- Navigate to the pom.xml file and right click it.
- Navigate to Maven, and click "Download sources and documentation"
- In the same menu click "Generate Sources And update folders"
- Navigate to test/java/ui
- For executing the tests, just right click and hit "run".

######################  Considerations  ######################

The objective of the existing test is to try to buy the second available phone from the huawei promotion banner
located in the banners sections of www.aliexpress.com. If the huawei banner is not located (since this are temporary promotions)
the test will fail accordingly.

Bear in mind that the purpose of this test was designed following the guidelines established in the deviget repository.
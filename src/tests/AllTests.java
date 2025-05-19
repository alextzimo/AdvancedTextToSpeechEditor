package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ EditDocumentTest.class, OpenExcelAtbashDocumentTest.class, OpenExcelDocumentTest.class, OpenExcelRot13DocumentTest.class, OpenWordAtbashDocumentTest.class, OpenWordDocumentTest.class, OpenWordRot13DocumentTest.class, SaveExcelAtbashDocumentTest.class, SaveExcelDocumentTest.class, SaveExcelRot13DocumentTest.class, SaveWordAtbashDocumentTest.class, SaveWordDocumentTest.class, SaveWordRot13DocumentTest.class, TTSFacadePlayPartTest.class, TTSFacadePlayTest.class, TuneAudioTest.class})

class AllTests {
}
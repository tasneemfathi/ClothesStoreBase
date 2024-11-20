package com.stores.clothes.ui.scence.intro.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stores.clothes.ui.scence.intro.view.sections.IndicatorSection
import com.stores.clothes.ui.scence.intro.view.sections.IntroActions
import com.stores.clothes.ui.scence.intro.view.sections.IntroPage
import com.stores.clothes.ui.scence.intro.view.sections.LangSwitcherSection
import com.stores.clothes.ui.scence.intro.viewModel.IntroViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun IntroScreenContent(viewModel: IntroViewModel, switchLang:()->Unit, onFinish:()->Unit){
    val pagerState = rememberPagerState(pageCount = { viewModel.introData.size })
    val animationScope = rememberCoroutineScope()
    Column (modifier = Modifier.fillMaxSize().systemBarsPadding(), verticalArrangement = Arrangement.spacedBy(30.dp), horizontalAlignment = Alignment.CenterHorizontally){
        LangSwitcherSection (switchLang = switchLang)
        HorizontalPager(state = pagerState) {
            IntroPage(viewModel.introData[pagerState.currentPage])
        }
        IndicatorSection( viewModel.introData.size, pagerState.currentPage)
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        IntroActions(currentIndex = pagerState.currentPage, next = {
            if(pagerState.currentPage == 2) onFinish() else scrollNextPage(animationScope, pagerState) }, skip = onFinish)

    }
}

private fun scrollNextPage(
    animationScope: CoroutineScope,
    pagerState: PagerState,
) {
    animationScope.launch {
        pagerState.animateScrollToPage( pagerState.currentPage + 1 )
    }
}
package com.adrielmadrigal.androidnews.newsitem.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adrielmadrigal.androidnews.R
import com.adrielmadrigal.androidnews.newsapi.data.model.ArticleModel

@Composable
fun NewsCardSummaryView(article: ArticleModel) {
    Column(
        modifier = Modifier
            .border(2.dp, Color.Yellow)
            .fillMaxWidth()
            .height(250.dp)
//            .clickable(onClick = )
    ) {
        Spacer(modifier = Modifier.size(5.dp))
        val imageModifier = Modifier
            .fillMaxHeight(.6f)
            .fillMaxWidth(.9f)
            .border(BorderStroke(1.dp, Color.Black))
            .align(CenterHorizontally)

        if (null != article.urlToImage) {
            println("async r.r")
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "Image random",
                contentScale = ContentScale.FillBounds,
                modifier = imageModifier
            )
        } else {
            println("no async n.n")
            Image(painter = painterResource(
                id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = imageModifier
            )
        }

        Text(
            text = article.sourceName,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        )
        Text(
            text = article.title,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        )
        Text(
            text = "Date published",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        )
    }
}

@Preview
@Composable
fun NewsCardSummaryView_Without_Image_Preview() {
    val articleModelApp = ArticleModel(
        "Dummiest News",
        "Random content that is going to be displayed",
        null,
    "The Verge")
    NewsCardSummaryView(articleModelApp)
}

@Preview
@Composable
fun NewsCardSummaryView_With_Image_Preview() {
    val articleModelApp = ArticleModel(
        "Dummiest News",
        "Random content that is going to be displayed",
        "https://media.wired.com/photos/65ea057df050a40d5b415477/191:100/w_2580,c_limit/AirPods-Guide-Gear.jpg",
    "The Verge")
    NewsCardSummaryView(articleModelApp)
}
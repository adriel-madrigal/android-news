package com.adrielmadrigal.androidnews.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.adrielmadrigal.androidnews.R
import com.adrielmadrigal.androidnews.domain.models.NewsArticle

@Composable
fun NewsCardSummaryView(article: NewsArticle) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.size(5.dp))
        val imageModifier = Modifier
            .width(180.dp)
            .height(100.dp)

        Row {
            if (null != article.urlToImage) {
                AsyncImage(
                    model = article.urlToImage,
                    contentDescription = "Image random",
                    contentScale = ContentScale.FillBounds,
                    modifier = imageModifier
                )
            } else {
                Image(painter = painterResource(
                    id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = imageModifier
                )
            }
        }
        Column {

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
}

@Preview
@Composable
fun NewsCardSummaryView_With_Image_Preview() {
    val request = ImageRequest
        .Builder(LocalContext.current)
        .data("Dummy Url")
        .placeholder(R.drawable.ic_launcher_background)
        .build()
    val articleModelApp = NewsArticle(
        "Dummiest News",
        "Random content that is going to be displayed",
        request,
        "The Verge")
    NewsCardSummaryView(articleModelApp)
}

@Preview
@Composable
fun NewsCardSummaryView_Without_Image_Preview() {
    val request = ImageRequest
        .Builder(LocalContext.current)
        .data("Dummy Url")
        .placeholder(R.drawable.ic_launcher_background)
        .build()
    val articleModelApp = NewsArticle(
        "Dummiest News",
        "Random content that is going to be displayed",
        request,
    "The Verge")
    NewsCardSummaryView(articleModelApp)
}


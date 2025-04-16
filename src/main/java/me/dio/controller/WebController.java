package me.dio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dio.domain.model.Account;
import me.dio.domain.model.Card;
import me.dio.domain.model.Feature;
import me.dio.domain.model.News;
import me.dio.service.AccountService;
import me.dio.service.CardService;
import me.dio.service.FeatureService;
import me.dio.service.NewsService;

@Controller
@RequestMapping("/web")
public class WebController {

    private final AccountService accountService;
    private final CardService cardService;
    private final FeatureService featureService;
    private final NewsService newsService;

    public WebController(AccountService accountService, CardService cardService,
                        FeatureService featureService, NewsService newsService) {
        this.accountService = accountService;
        this.cardService = cardService;
        this.featureService = featureService;
        this.newsService = newsService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "accounts/list";
    }

    @GetMapping("/accounts/new")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "accounts/form";
    }

    @GetMapping("/accounts/edit/{id}")
    public String editAccount(@PathVariable Long id, Model model) {
        model.addAttribute("account", accountService.findById(id));
        return "accounts/form";
    }

    @PostMapping("/accounts/save")
    public String saveAccount(@ModelAttribute Account account) {
        if (account.getId() == null) {
            accountService.create(account);
        } else {
            accountService.update(account.getId(), account);
        }
        return "redirect:/web/accounts";
    }

    @GetMapping("/cards")
    public String cards(Model model) {
        model.addAttribute("cards", cardService.findAll());
        return "cards/list";
    }

    @GetMapping("/cards/new")
    public String newCard(Model model) {
        model.addAttribute("card", new Card());
        return "cards/form";
    }

    @GetMapping("/cards/edit/{id}")
    public String editCard(@PathVariable Long id, Model model) {
        model.addAttribute("card", cardService.findById(id));
        return "cards/form";
    }

    @PostMapping("/cards/save")
    public String saveCard(@ModelAttribute Card card) {
        if (card.getId() == null) {
            cardService.create(card);
        } else {
            cardService.update(card.getId(), card);
        }
        return "redirect:/web/cards";
    }

    @GetMapping("/features")
    public String features(Model model) {
        model.addAttribute("features", featureService.findAll());
        return "features/list";
    }

    @GetMapping("/features/new")
    public String newFeature(Model model) {
        model.addAttribute("feature", new Feature());
        return "features/form";
    }

    @GetMapping("/features/edit/{id}")
    public String editFeature(@PathVariable Long id, Model model) {
        model.addAttribute("feature", featureService.findById(id));
        return "features/form";
    }

    @PostMapping("/features/save")
    public String saveFeature(@ModelAttribute Feature feature) {
        if (feature.getId() == null) {
            featureService.create(feature);
        } else {
            featureService.update(feature.getId(), feature);
        }
        return "redirect:/web/features";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", newsService.findAll());
        return "news/list";
    }

    @GetMapping("/news/new")
    public String newNews(Model model) {
        model.addAttribute("news", new News());
        return "news/form";
    }

    @GetMapping("/news/edit/{id}")
    public String editNews(@PathVariable Long id, Model model) {
        model.addAttribute("news", newsService.findById(id));
        return "news/form";
    }

    @PostMapping("/news/save")
    public String saveNews(@ModelAttribute News news) {
        if (news.getId() == null) {
            newsService.create(news);
        } else {
            newsService.update(news.getId(), news);
        }
        return "redirect:/web/news";
    }
} 